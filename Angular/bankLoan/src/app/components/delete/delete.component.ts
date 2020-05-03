import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/service/book.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Profile } from 'src/app/model/profile';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css'],
  

})
export class DeleteComponent implements OnInit {
  isValidFormSubmitted = false;
	allProfiles: Profile[];
	userForm: FormGroup;

  
  constructor(private formBuilder:FormBuilder,private service:BookService){}
  ngOnInit() {
    this.userForm = this.formBuilder.group({
      profile: [null, [Validators.required]],
    });
    this.allProfiles = this.service.getPofiles();
  }
  get profile() {
		return this.userForm.get('profile');
	}
  onFormSubmit() {
		this.isValidFormSubmitted = false;
		if (this.userForm.valid) {
			this.isValidFormSubmitted = true;
		} else {
			return;
		}
		let newUser: User = this.userForm.value;
		this.service.createUser(newUser);
		this.resetForm(this.userForm);
	}
	resetForm(form: FormGroup) {
		form.reset();
  }
  setDefaultValues() {
		let user = new User();
		user.profile = this.allProfiles[2];
		this.userForm.setValue(user);
	}
	// onProfileChange() {
	// 	let profile: Profile = this.profile.value;
	// 	console.log('Profile Changed: ' + profile.prName);
	// }
}
