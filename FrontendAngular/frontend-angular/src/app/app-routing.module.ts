import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { NewspaperComponent } from './newspaper/newspaper.component';

const routes: Routes = [
  { path: 't', component: NavbarComponent },
  { path: 'n', component: NewspaperComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
