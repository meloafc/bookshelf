import { Component, OnInit } from '@angular/core';
import { Login } from '../providers/models/login.model';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.scss']
})
export class PagesComponent implements OnInit {

  user: Login = new Login();

  constructor() { }

  ngOnInit(): void {
  }

}
