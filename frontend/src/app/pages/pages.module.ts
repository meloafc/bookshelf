import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../shared/material/material.module';
import { LoginComponent } from './login/login.component';
import { PagesRoutes } from './pages.routing';
import { SignupComponent } from './signup/signup.component';
import { ListBookComponent } from './list-book/list-book.component';
import { NewBookComponent } from './new-book/new-book.component';

@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent,
    ListBookComponent,
    NewBookComponent
  ],
  entryComponents: [
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,
    RouterModule.forChild(PagesRoutes),
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ]
})
export class PagesModule { }