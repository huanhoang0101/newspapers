import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { NewspaperComponent } from './component/newspaper/newspaper.component';
import { DetailNewspaperComponent } from './component/detail-newspaper/detail-newspaper.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NewspaperComponent,
    DetailNewspaperComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
