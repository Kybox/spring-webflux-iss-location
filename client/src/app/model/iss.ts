import {Gps} from './gps';

export class Iss {

  public timestamp?: string;
  public message?: string;
  public iss_position?: Gps;

  constructor(timestamp: string, message: string, gps: Gps) {
    this.timestamp = timestamp;
    this.message = message;
    this.iss_position = gps;
  }
}
