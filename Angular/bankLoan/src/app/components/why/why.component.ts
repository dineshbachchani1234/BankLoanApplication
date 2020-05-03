import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-why',
  templateUrl: './why.component.html',
  styleUrls: ['./why.component.css'],
  providers: [NgbCarouselConfig]
})
export class WhyComponent implements OnInit {

  constructor(config:NgbCarouselConfig) {

    config.interval = 5000;
    config.wrap = true;
    config.keyboard = true;
    config.pauseOnHover=false;
   }
  ngOnInit() {
  }

}
