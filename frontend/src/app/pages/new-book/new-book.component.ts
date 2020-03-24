import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../../providers/models/book';
import { BookService } from '../../providers/services/book.service';

@Component({
  selector: 'app-new-book',
  templateUrl: './new-book.component.html',
  styleUrls: ['./new-book.component.scss']
})
export class NewBookComponent implements OnInit {

  public book: Book = new Book();

  constructor(
    private bookService: BookService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  save() {
    if(!this.book.title) {
      alert('Title is required');
      return;
    }

    this.bookService.add(this.book).subscribe(
      json => {
        alert('Book saved');
        this.navigateToBooks();
      },
      erro => {
        alert(erro.error.message);
      }
    );
  }

  navigateToBooks() {
    this.router.navigate(['/pages/list-book']);
  }

}
