import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

import {SERVER_API_URL} from '../app.constants';
import {IQuote} from "./quote.model";
import {Injectable} from "@angular/core";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable()
export class SubscriptionService {
  private resourceUrl = SERVER_API_URL + 'subscribe';

  constructor(private http: HttpClient) {
  }


  save(s) {
    let body = JSON.stringify(s);
    return this.http.post(`${this.resourceUrl}/`, body, httpOptions);
  }

}
