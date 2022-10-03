import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../_services/user-auth.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  errors!: Boolean
  constructor(
    private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {  this.errors = false}

  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe(
      (response: any) => {
        console.log(response);
        this.errors = false;
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.token);
        const role = response.user.role;
        if (role === 'ROLE_MANAGER') {
          this.router.navigate(['/admin']);
        } else  if (role === 'ROLE_IT_SUPPORT') {
          this.router.navigate(['/user']);
        }
      },
      (error) => {
        this.errors = true;
        console.log(error);
      }
    );
  }
}
