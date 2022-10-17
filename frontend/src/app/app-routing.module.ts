import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HistoryComponent } from './history/history.component';
import { HomeComponent } from './home/home.component';
import { ItSupportNjComponent } from './it-support-nj/it-support-nj.component';
import { ListNjComponent } from './list-nj/list-nj.component';
import { LoginComponent } from './login/login.component';
import { ManagerListNjComponent } from './manager-list-nj/manager-list-nj.component';
import { NjDetailsComponent } from './nj-details/nj-details.component';
import { ViewHistoryComponent } from './view-history/view-history.component';
import { AuthGuard } from './_auth/auth.guard';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']} },
  { path: 'user', component: ListNjComponent ,  canActivate:[AuthGuard], data:{roles:['ROLE_IT_SUPPORT']} },
  { path: 'assign', component: ItSupportNjComponent ,  canActivate:[AuthGuard], data:{roles:['ROLE_IT_SUPPORT']} },
  { path: 'list', component: ManagerListNjComponent, canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']}},
  { path: 'login', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'history', component: HistoryComponent },
  { path: 'history/newJoiner/:id', component: ViewHistoryComponent },
  { path: 'newJoiner/:id', component: NjDetailsComponent , canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']}},
  { path: 'newJoiner/:id/it-support', component: ItSupportNjComponent , canActivate:[AuthGuard], data:{roles:['ROLE_IT_SUPPORT']}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
