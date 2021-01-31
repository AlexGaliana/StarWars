import { Component, OnInit } from '@angular/core';
import { FormBuilder,  FormControl,  FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Register } from '../list-registro/service/register';
import { RegisterServiceService } from './service/register-service.service';

@Component({
  selector: 'app-formulario-registro',
  templateUrl: './formulario-registro.component.html',
  styleUrls: ['./formulario-registro.component.scss']
})
export class FormularioRegistroComponent implements OnInit {
  model: Register = {name:'',planet:'',date:''}
  form = new FormGroup({

    nombre: new FormControl('', [Validators.required, Validators.minLength(3)]),
    planeta: new FormControl('', [Validators.required, Validators.minLength(5)])
  });
constructor(private registerServiceService: RegisterServiceService,private router:Router){}
  submit() {

    var d = new Date,
    fecha = [d.getMonth()+1,
               d.getDate(),
               d.getFullYear()].join('/')+' '+
              [d.getHours(),
               d.getMinutes(),
               d.getSeconds()].join(':');
    this.model.date=fecha.toString();
    //console.log(fecha.toString());
    //console.log(this.model);
    this.registerServiceService.crearRegistro(this.model).subscribe((response: Register) => console.log(response));
    this.router.navigate(['list']);
  }




  ngOnInit(): void {


  }

}
