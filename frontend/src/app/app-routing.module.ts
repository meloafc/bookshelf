import { Routes } from '@angular/router';
import { PagesComponent } from './pages/pages.component';


export const AppRoutes: Routes = [
  {
    path: 'pages',
    component: PagesComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('./pages/pages.module').then(m => m.PagesModule)
      }
    ]
  }
];
