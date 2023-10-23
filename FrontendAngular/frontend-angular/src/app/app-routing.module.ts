import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './component/navbar/navbar.component';
import { NewspaperComponent } from './component/newspaper/newspaper.component';
import { DetailNewspaperComponent } from './component/detail-newspaper/detail-newspaper.component';

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
