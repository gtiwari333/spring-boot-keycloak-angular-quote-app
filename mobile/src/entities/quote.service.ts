import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

import {SERVER_API_URL} from '../app/app.constants';
import {IQuote} from "./quote.model";
import {Injectable} from "@angular/core";

@Injectable()
export class QuoteService {
  private resourceUrl = SERVER_API_URL + 'quotes';

  constructor(private http: HttpClient) {
  }

  getQuotes(size?: number): Observable<any> {
    return this.http
      .get<IQuote>(`${this.resourceUrl}/${size}`);
  }

}
