import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  error: string;

  constructor(private auth: AuthService, private router: Router) { }

  changePassword(form: NgForm) {
    this.error = null;
    this.auth.changePasswordUser(form.value).subscribe(res => {
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
