import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

import {SERVER_API_URL} from '../app.constants';
import {IQuote} from "./quote.model";
import {Injectable} from "@angular/core";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable()
export class QuoteService {
  private resourceUrl = SERVER_API_URL + 'quotes';

  constructor(private http: HttpClient) {
  }

  getQuotes(size?: number): Observable<any> {
    return this.http
      .get<IQuote>(`${this.resourceUrl}/${size}`);
  }

  getQuoteById(id?: number): Observable<any> {
    return this.http
      .get<IQuote>(`${this.resourceUrl}/id/${id}`);
  }


  saveNote(note) {
    let body = JSON.stringify(note);
    return this.http.post(`${this.resourceUrl}/`, body, httpOptions);
  }

}
