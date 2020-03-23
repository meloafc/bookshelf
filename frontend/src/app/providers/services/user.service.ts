import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../models/login';
import { Token } from '../models/token';
import { User } from '../models/user';
import { ENDPOINTS } from '../../../app/constants';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private static readonly CURRENT_USER = 'currentUser';
  private usersUrl = environment.apiUrl + ENDPOINTS.USERS;

  constructor(private http: HttpClient) {

  }

  setCurrentUser(token: Token) {
    localStorage.setItem(UserService.CURRENT_USER, JSON.stringify(token));
  }

  getCurrentUser(): Token {
    return JSON.parse(localStorage.getItem(UserService.CURRENT_USER));
  }

  logout() {
    localStorage.removeItem(UserService.CURRENT_USER);
  }

  authenticate(login: Login): Observable<Token> {
    return this.http.post<Token>(this.usersUrl + '/authenticate', login);
  }

  register(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl + '/register', user);
  }

}
