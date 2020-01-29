import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IssService {

  constructor(private http: HttpClient) {
  }

  public getPosition(): Observable<any> {
    return new Observable(obs => {
      const evtSrc = new EventSource('http://localhost:8080/now');
      evtSrc.addEventListener('message', (evt) => obs.next(evt.data));
      return () => {
        console.log('CLOSE');
        evtSrc.close();
      };
    });
  }
}
