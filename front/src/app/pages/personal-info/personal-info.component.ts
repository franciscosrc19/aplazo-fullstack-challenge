import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent {
  personalInfoForm: FormGroup;

  constructor(private fb: FormBuilder, private customerService: CustomerService) {
    this.personalInfoForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      secondLastName: ['', Validators.required],
      dateOfBirth: ['', Validators.required]
    });
  }

  submit() {
    if (this.personalInfoForm.valid) {
      this.customerService.createCustomer(this.personalInfoForm.value).subscribe(response => {
        console.log('Customer created', response);
      });
    }
  }
}
