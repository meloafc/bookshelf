import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../../providers/models/login';
import { UserService } from '../../providers/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public login: Login = new Login();

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {

  }

  doLogin() {
    this.userService.authenticate(this.login).subscribe(
      json => {
        this.userService.setCurrentUser(json);
        this.navigateToBooks();
      },
      erro => {
        alert('Username or Password is invalid');
      }
    );
  }

  navigateToBooks() {
    this.router.navigate(['/pages/list-book']);
  }

}
