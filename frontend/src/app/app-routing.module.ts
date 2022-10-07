import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { ListNjComponent } from './list-nj/list-nj.component';
import { LoginComponent } from './login/login.component';
import { NjDetailsComponent } from './nj-details/nj-details.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './_auth/auth.guard';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['ROLE_MANAGER']} },
  { path: 'user', component: UserComponent ,  canActivate:[AuthGuard], data:{roles:['ROLE_IT_SUPPORT']} },
  { path: 'list', component: ListNjComponent},
  { path: 'login', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  {
    path: 'newJoiner/:id',
    component: NjDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
