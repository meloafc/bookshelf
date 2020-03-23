import { Component, OnInit } from '@angular/core';
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
    private userService: UserService
  ) { }

  ngOnInit(): void {

  }

  doLogin() {
    this.userService.authenticate(this.login).subscribe(
      json => {
        console.log(json);
        alert('Logged');
      },
      erro => {
        alert('Username or Password is invalid');
      }
    );
  }

}
