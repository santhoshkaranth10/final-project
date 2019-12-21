import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message;
  get email() {
    return this.form.get('email');
  }
  get password() {
    return this.form.get('password');
  }

  constructor(private auth: AuthService, private router: Router) { }

  form = new FormGroup({
    email : new FormControl('', [Validators.required]),
    password : new FormControl('', [Validators.required])
  });

  error = String;

  login(form: NgForm) {

    console.log(form.value);
    this.auth.loginUser(form.value).subscribe(data => {
      console.log('Response of login', data);
      if (data && data.message === 'Success') {
        localStorage.setItem('userDetails', JSON.stringify(data));
        alert('login successful');
        this.router.navigateByUrl('/home');
      } else {
        alert('invalid credential');
      }
      form.reset();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
