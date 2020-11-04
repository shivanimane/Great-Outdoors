import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient,HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ProductMasterComponent } from './product-master/product-master.component';
import { RetailerComponent } from './retailer/retailer.component';
import { AddUserComponent } from './add-user/add-user.component';
import { ListUserComponent } from './list-user/list-user.component';

const routes : Routes = [
  {path:'login', component:LoginComponent},
  {path:'', redirectTo:'login', pathMatch:"full"},
  {path:'*', redirectTo:'login', pathMatch:"full"},
  // {path:'admin', component:AdminComponent,canActivate: [AuthGuard]},
  // {path:'home', component:HomeComponent},
  // {path:'add-course', component:AddCourseComponent},
  // {path:'list-course', component:ListCourseComponent ,canActivate: [AuthGuard]},
  // {path:'add-faculty', component:AddFacultyComponent},
  // {path:'list-faculty', component:ListFacultyComponent},
  // {path:'coordinator', component:CoordinatorComponent,canActivate: [AuthGuard]},
  // {path:'add-feedback/:tId/:fId', component:AddFeedbackComponent},
  // {path:'add-training',component:AddTrainingprogramComponent},
  // {path:'list-training',component:ListTrainingProgramComponent},
  // {path:'list-participant', component:ListParticipantComponent},
  // {path:'list-feedback-faculty/:id', component: ListFeedbackFacultyComponent},
  // {path:'enroll-participant' , component:AddParticipantComponent},
  // {path:'participant', component:ParticipantComponent,canActivate: [AuthGuard]},
  // {path:'error/:errMsg', component:ErrorComponent},
  // {path:'list-feedback-faculty/:id', component: ListFeedbackFacultyComponent},
  // {path:'list-feedback-training-program/:tId', component: ListFeedbackTrainingProgramComponent},
  // {path:'register', component: RegisterComponent},
  // {path:'', redirectTo:'login', pathMatch:"full"},
  // {path:'*', redirectTo:'login', pathMatch:"full"},
  //{path:'admin/add-course', component: AddCourseComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AdminComponent,
    ProductMasterComponent,
    RetailerComponent,
    AddUserComponent,
    ListUserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }