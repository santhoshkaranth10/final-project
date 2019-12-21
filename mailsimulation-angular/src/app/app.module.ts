import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReceivedmailComponent } from './receivedmail/receivedmail.component';
import { InboxComponent } from './inbox/inbox.component';
import { SentComponent } from './sent/sent.component';
import { DeleteComponent } from './delete/delete.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { ComposemailComponent } from './composemail/composemail.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ReceivedmailComponent,
    InboxComponent,
    SentComponent,
    DeleteComponent,
    ChangepasswordComponent,
    ComposemailComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'register', component: RegisterComponent},
      {path: 'login', component: LoginComponent},
      {path: 'home', component: HomeComponent},
      {path: 'inbox', component: InboxComponent},
      {path: 'delete', component: DeleteComponent},
      {path: 'receivedmail', component: ReceivedmailComponent},
      {path: 'sent', component: SentComponent},
      {path: 'changepassword', component: ChangepasswordComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
