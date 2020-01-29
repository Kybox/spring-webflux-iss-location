import {Component, OnInit} from '@angular/core';
import {IssService} from './service/iss.service';
import {Iss} from './model/iss';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public lat = 40.730610;
  public lng = -73.935242;
  public mapType: string;
  public zoom = 3;
  public icon: any;

  constructor(private issService: IssService) {
    this.mapType = 'hybrid';
    this.icon = {
      url: '../assets/international-space-station-icon.png',
      scaledSize: {
        width: 50,
        height: 50
      }
    };
  }

  public ngOnInit(): void {
    this.getPosition();
  }

  private getPosition(): void {
    this.issService.getPosition().subscribe(
      next => {
        const iss: Iss = JSON.parse(next);
        console.log(iss);
        console.log('lat : ' + iss.iss_position.latitude);
        console.log('lng : ' + iss.iss_position.longitude);
        this.lat = parseFloat(iss.iss_position.latitude);
        this.lng = parseFloat(iss.iss_position.longitude);
      },
      error => console.log(error)
    );
  }
}
