import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { UserService } from './_services/user.service';
import { ListNjComponent } from './list-nj/list-nj.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { NjDetailsComponent } from './nj-details/nj-details.component';
import { DragDropModule } from '@angular/cdk/drag-drop';
import {ScrollingModule} from '@angular/cdk/scrolling';
import { HistoryComponent } from './history/history.component';
import { ItSupportNjComponent } from './it-support-nj/it-support-nj.component';
import { ManagerListNjComponent } from './manager-list-nj/manager-list-nj.component';
import { ViewHistoryComponent } from './view-history/view-history.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    HeaderComponent,
    ForbiddenComponent,
    ListNjComponent,
    NjDetailsComponent,
    HistoryComponent,
    ItSupportNjComponent,
    ManagerListNjComponent,
    ViewHistoryComponent
  ],
  imports: [
    BrowserModule,
    DragDropModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule, 
    RouterModule, ScrollingModule, BrowserAnimationsModule
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },{provide: LocationStrategy, useClass: HashLocationStrategy},
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
