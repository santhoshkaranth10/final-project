import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-receivedmail',
  templateUrl: './receivedmail.component.html',
  styleUrls: ['./receivedmail.component.css']
})
export class ReceivedmailComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) {

    
   }
 
  ngOnInit() {
  }

}
