import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ListBookComponent } from './list-book/list-book.component';

export const PagesRoutes: Routes = [
    {

        path: '',
        children: [
            {
                path: '',
                redirectTo: 'login',
                pathMatch: 'full',
            },
            {
                path: 'login',
                component: LoginComponent
            },
            {
                path: 'signup',
                component: SignupComponent
            },
            {
                path: 'list-book',
                component: ListBookComponent
            }
        ]
    }
];
