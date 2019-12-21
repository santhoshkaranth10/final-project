import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  registerUser(user): Observable<any> {
    return this.http.post('http://localhost:8080/register', user);
  }

  loginUser(user): Observable<any> {
    return this.http.post('http://localhost:8080/login', user);
  }

  changePasswordUser(user): Observable<any> {
    return this.http.post('http://localhost:8080/changepassword', user);
  }

  deleteEmail(id): Observable <any> {
    return this.http.delete(`http://localhost/8080/delete${id}`, id);
  }

  composeEmail(info): Observable <any> {
    return this.http.post('http://localhost:8080/compose', info);
  }
   sendMail(info): Observable <any> {
     return this.http.post('http://localhost:8080/mailsimulation/sendmail', info);
   }

   sentMails(): Observable <any> {
    return this.http.get('http://localhost:8080/mailsimulation/sentmails' );

   }
   draftmails(): Observable <any> {
    return this.http.get('http://localhost:8080/mailsimulation/draftmails' );
   }
   getallmails(): Observable <any> {
    return this.http.get('http://localhost:8080/mailsimulation/getallmails' );
   }
   inbox(): Observable <any> {
    return this.http.get('http://localhost:8080/mailsimulation/inbox');
   }
  }


