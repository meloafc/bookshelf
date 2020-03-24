import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../models/book';
import { ENDPOINTS } from '../../../app/constants';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private booksUrl = environment.apiUrl + ENDPOINTS.BOOKS;

  constructor(private http: HttpClient) {

  }

  getAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl);
  }

  add(book: Book): Observable<Book> {
    return this.http.post<Book>(this.booksUrl, book);
  }

  remove(book: Book): Observable<any> {
    return this.http.delete(this.booksUrl + '/' + book.id);
  }

}
