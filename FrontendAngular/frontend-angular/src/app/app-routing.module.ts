import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { NewspaperComponent } from './newspaper/newspaper.component';
import { DetailNewspaperComponent } from './detail-newspaper/detail-newspaper.component';

const routes: Routes = [
  { path: 'bar', component: NavbarComponent },
  { path: '', component: NewspaperComponent },
  { path: 'd/:id', component: DetailNewspaperComponent },
  { path: '**', component: NewspaperComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
