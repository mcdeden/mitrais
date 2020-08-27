import { logging } from 'protractor';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormBuilder,
  FormControl,
  Validators,
} from '@angular/forms';
import {
  trigger,
  state,
  style,
  transition,
  animate,
} from '@angular/animations';
import { DataService } from '../service/data.service';
import { Observable } from 'rxjs';
import { Data, AjaxResponse } from '../interface/data';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from '../_model/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  animations: [
    trigger('areaCode', [
      state('true', style({ opacity: 1, offset: 1 })),
      state('false', style({ opacity: 0.1, offset: 0.1 })),
      transition('false <=> true', animate(300)),
    ]),

    trigger('error', [
      state('true', style({ opacity: 1, offset: 1 })),
      state('false', style({ opacity: 0, offset: 0 })),
      transition('false <=> true', animate(300)),
    ]),
  ],
})
export class RegisterComponent implements OnInit {
  form: FormGroup;
  isLoading: boolean = false;
  isRegistered: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private dataService: DataService,
    private messageAlert: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      mobileNumber: new FormControl(null, [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(15),
        Validators.pattern('^(8|08)[2-9]{1}[0-9]+$'),
      ]),
      firstName: new FormControl(null, [
        Validators.required,
        Validators.pattern('^[a-zA-Z-,]+(s{0,1}[a-zA-Z-, ])*$'),
      ]),
      lastName: new FormControl(null, [
        Validators.required,
        Validators.pattern('^[a-zA-Z-,]+(s{0,1}[a-zA-Z-, ])*$'),
      ]),
      birthDate: new FormControl(null),
      email: new FormControl(null, [Validators.required, Validators.email]),
      genderId: new FormControl(null),
    });
  }

  // mergeObjModel(obj): User {
  //   const objModel = new User();
  //   objModel.mobileNumber = obj.mobileNumber;
  //   objModel.firstName = obj.firstName;
  //   objModel.lastName = obj.lastName;
  //   // if (obj.year_birth && obj.month_birth && obj.date_birth) {
  //   //   objModel.birthDate = `${obj.year_birth}-${obj.month_birth}-${obj.date_birth}`;
  //   // } else {
  //   //   objModel.date_birth = '';
  //   // }
  //   objModel.birthDate = this.dataService.transformDate(
  //     this.form.value.birthDate
  //   );
  //   objModel.genderId = obj.genderId;
  //   objModel.email = obj.email;
  //   return objModel;
  // }

  onSubmit(): void {
    // CHECKING THE SUBMITTED DATA
    console.log(this.form.value);
    if (this.form.invalid) {
      // SHOW AN ERROR IF ANY ERROR
      this.form.markAllAsTouched();
    } else {
      // CONVERTING DATE INTO (yyyy-MM-dd)
      const convertingDate = new Observable((subscribe) => {
        this.isLoading = true;
        subscribe.next(
          this.dataService.transformDate(this.form.value.birthDate)
        );
      });
      convertingDate.subscribe((newDate: string) => {
        this.form.value.birthDate = newDate;
      });

      //post data
      let endpoint = '/user/register';
      this.dataService.sendPostRequest(this.form.value, endpoint).subscribe(
        (data: AjaxResponse<Response[]>) => {
          this.form.disable();
          this.isRegistered = true;
          // }
          this.messageAlert.open(data.message, 'Close', {
            duration: 5000,
          });
        },
        (err) => {
          this.messageAlert.open('Fail to create user', 'Close', {
            duration: 5000,
          });
        }
      );
    }
  }

  // INIT ERROR MSG (GLOBAL)
  errorMsg(p: any) {
    return p.invalid && (p.dirty || p.touched);
  }

  // INIT THE PARAMETER
  get mobileNumber() {
    return this.form.get('mobileNumber');
  }

  get firstName() {
    return this.form.get('firstName');
  }

  get lastName() {
    return this.form.get('lastName');
  }

  get birthDate() {
    return this.form.get('birthDate');
  }

  get email() {
    return this.form.get('email');
  }
}
