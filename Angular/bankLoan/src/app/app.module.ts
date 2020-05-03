import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { MatFormFieldModule, MatIconModule } from '@angular/material';
import { MatInputModule } from '@angular/material';
import { MAT_LABEL_GLOBAL_OPTIONS } from '@angular/material/core';
import { CheckBalanceComponent } from './components/check-balance/check-balance.component';
import { ApplyLoanComponent } from './components/apply-loan/apply-loan.component';
import { PayEmiComponent } from './components/pay-emi/pay-emi.component';
import { ShowTransactionsComponent } from './components/show-transactions/show-transactions.component';
import {MatTableModule} from '@angular/material/table';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { WhyComponent } from './components/why/why.component';
import { CalculateemiComponent } from './components/calculateemi/calculateemi.component';
import { ForecloseComponent } from './components/foreclose/foreclose.component';
import { LoginHeaderComponent } from './components/login-header/login-header.component';
import { PaymentComponent } from './components/payment/payment.component';
import { EmishowComponent } from './components/emishow/emishow.component';
import { AfteremiComponent } from './components/afteremi/afteremi.component';
import { Foreclose2Component } from './components/foreclose2/foreclose2.component';
import { DeleteComponent } from './components/delete/delete.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    CheckBalanceComponent,
    ApplyLoanComponent,
    PayEmiComponent,
    ShowTransactionsComponent,
    HeaderComponent,
    FooterComponent,
    AboutComponent,
    ContactComponent,
    WhyComponent,
    CalculateemiComponent,
    ForecloseComponent,
    LoginHeaderComponent,
    PaymentComponent,
    EmishowComponent,
    AfteremiComponent,
    Foreclose2Component,
    DeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    NgbModule
  ],
  providers: [
    { provide: MAT_LABEL_GLOBAL_OPTIONS, useValue: {float: 'always'} }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
