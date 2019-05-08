import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { MatSidenavModule } from "@angular/material/sidenav";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatButtonModule } from "@angular/material/button";
import { MatListModule } from '@angular/material/list';
import { MatDividerModule } from '@angular/material/divider';
import { MatStepperModule } from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material';
import { MatDialogModule } from '@angular/material';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UserserviceService } from './userservice.service';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ProjectCardUserDashboardComponent } from './project-card-user-dashboard/project-card-user-dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { ProjectDetailFormComponent } from './project-detail-form/project-detail-form.component';
import { ProjectDetailsService } from './project-details.service';
import { AuthGuard } from './auth-guard';
import { FreelancerdetailsComponent } from './freelancerdetails/freelancerdetails.component';
import { FreelancerDetailsService } from './freelancer-details.service';
import { FooterComponent } from './footer/footer.component';
import { MybidsComponent } from './mybids/mybids.component';
import { MybidscardComponent } from './mybidscard/mybidscard.component';
import { ProjectOwnerDashboardComponent } from './project-owner-dashboard/project-owner-dashboard.component';
import { UsercardProjectOwnerDashboardComponent } from './usercard-project-owner-dashboard/usercard-project-owner-dashboard.component';
import { MyprojectsComponent } from './myprojects/myprojects.component';
import { ProjectCardProductOwnerMyprojectComponent } from './project-card-product-owner-myproject/project-card-product-owner-myproject.component';
import { FreelancerProjectDetailsComponent } from './freelancer-project-details/freelancer-project-details.component';
import { ProductownerprofileComponent } from './productownerprofile/productownerprofile.component';
import { HomeComponent } from './home/home.component';
import { EditfreelancerProfileComponent } from './editfreelancer-profile/editfreelancer-profile.component';
import { FreelancerprofileComponent } from './freelancerprofile/freelancerprofile.component';
import { EditProjectOwnerProfileComponent } from './edit-project-owner-profile/edit-project-owner-profile.component';
import { ProjectOwnerProfileComponent } from './project-owner-profile/project-owner-profile.component';
import { ProjectDetailsViewComponent } from './project-details-view/project-details-view.component';
import { ViewProfileDailogComponent } from './view-profile-dailog/view-profile-dailog.component';
import { BidviewComponent } from './bidview/bidview.component';
import { ProductownerdetailsService } from './productownerdetails.service';
import { SearchComponentComponent } from './search-component/search-component.component';
import { InviteFreelancerComponent } from './invite-freelancer/invite-freelancer.component';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    UserDashboardComponent,
    ProjectCardUserDashboardComponent,
    FreelancerdetailsComponent,
    ProjectDetailsComponent,
    ProjectDetailFormComponent,
    FooterComponent,
    ProjectDetailFormComponent,
    MybidsComponent,
    MybidscardComponent,
    FreelancerProjectDetailsComponent,
    ProductownerprofileComponent,
    ProjectOwnerDashboardComponent,
    UsercardProjectOwnerDashboardComponent,
    MyprojectsComponent,
    ProjectCardProductOwnerMyprojectComponent,
    HomeComponent, EditfreelancerProfileComponent,
    FreelancerprofileComponent,
    EditProjectOwnerProfileComponent,
    ProjectOwnerProfileComponent,
    EditfreelancerProfileComponent,
    ProjectDetailsViewComponent,
    ProjectDetailsComponent,
    ViewProfileDailogComponent,
    BidviewComponent,
    SearchComponentComponent,
    InviteFreelancerComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatListModule,
    MatDividerModule,
    MatStepperModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule
  ],
  providers: [
    UserserviceService,
    ProjectDetailsService,
    FreelancerDetailsService,
    AuthGuard,
    HttpClientModule,
    ProductownerdetailsService,
    FormsModule,
    Location
  ],
  entryComponents: [ViewProfileDailogComponent, BidviewComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

