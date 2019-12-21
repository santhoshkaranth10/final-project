import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  error: string;

  constructor(private auth: AuthService, private router: Router) { }

  register(form: NgForm) {
    this.error = null;
    this.auth.registerUser(form.value).subscribe(res => {
      console.log(res);
      this.router.navigateByUrl('/login');
      form.reset();
    }, err => {
      console.log(err);
      this.error = err.error.message;
    });
  }

  ngOnInit() {
  }

}
