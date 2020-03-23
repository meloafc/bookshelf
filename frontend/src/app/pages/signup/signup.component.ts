import { Component, OnInit } from '@angular/core';
import { User } from '../../providers/models/user';
import { UserService } from '../../providers/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  public user: User = new User();

  constructor(
    private userService: UserService
  ) { }

  ngOnInit(): void {
  }

  register() {
    if(!this.user.email || !this.user.name || !this.user.password || !this.user.confirmPassword) {
      alert('Fill in all fields');
      return;
    }

    if(this.user.password !== this.user.confirmPassword) {
      alert('different passwords');
      return;
    }

    this.userService.register(this.user).subscribe(
      json => {
        alert('Saved');
      },
      erro => {
        if((<string>erro.error.message).includes('must be a well-formed email address')) {
          alert('Invalid email');
        } else {
          alert(erro.error.message);
        }
      }
    );
  }

}
