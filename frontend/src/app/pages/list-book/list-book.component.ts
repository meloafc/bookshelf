import { Component, OnInit } from '@angular/core';
import { UserService } from '../../providers/services/user.service';
import { BookService } from '../../providers/services/book.service';
import { Book } from '../../providers/models/book';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.scss']
})
export class ListBookComponent implements OnInit {

  public books: Book[] = [];

  constructor(
    private userService: UserService,
    private bookService: BookService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadList();
  }

  loadList() {
    this.bookService.getAll().subscribe(
      json => {
        this.books = json;
      },
      erro => {
        alert('Error when trying to load list');
      }
    );
  }

  delete(book: Book) {
    this.bookService.remove(book).subscribe(
      json => {
        this.loadList();
      },
      erro => {
        alert('Error when trying to remove book');
      }
    );
  }

  logout() {
    this.userService.logout();
    this.navigateToLogin();
  }

  navigateToLogin() {
    this.router.navigate(['/pages/login']);
  }

}
