import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Imc } from "../model/imc.model";
import { ImcService } from "../service/imc.service";
import { UsuarioService } from "../service/usuario.service";
import { Usuario } from "./../model/usuario.model";
import { LocalStorageService } from "./../service/local-storage.service";

@Component({
  selector: "app-index",
  templateUrl: "index.component.html",
})
export class IndexComponent implements OnInit {
  localStorage = this.storage;
  form: FormGroup;
  imcLista: Imc[] = [];
  error: object;
  imcMensagem: object;
  constructor(
    private storage: LocalStorageService,
    private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private imcService: ImcService
  ) {}

  ngOnInit() {
    this.form = this.fb.group({
      nome: [null, Validators.required],
      peso: [null, Validators.required],
      altura: [null, Validators.required],
    });
    if (this.storage.get("usuario")) {
      this.form.get("nome").setValue(this.storage.get("usuario").nome);
      this.buscarTodos();
    }
    var body = document.getElementsByTagName("body")[0];
    body.classList.add("index-page");
  }

  private buscarTodos() {
    if (this.storage.get("usuario")) {
      this.imcService.getAll(this.storage.get("usuario").id).subscribe(
        (imc) => {
          this.imcLista = imc;
        },
        (error) => {
          console.error(error);
        }
      );
    }
  }

  calcular(): void {
    const usuario = new Usuario();
    const imcEntity = new Imc();
    let idUsuario: number;
    usuario.nome = this.form.get("nome").value;
    imcEntity.altura = this.form.get("altura").value;
    imcEntity.peso = this.form.get("peso").value;
    if (!this.storage.get("usuario")) {
      this.usuarioService.save(usuario).subscribe(
        (usuario) => {
          idUsuario = usuario.id;
          this.storage.set("usuario", usuario);
          this.salvarImc(idUsuario, imcEntity);
        },
        (error) => {
          console.error(error);
        }
      );
    } else {
      idUsuario = this.storage.get("usuario").id;
      this.salvarImc(idUsuario, imcEntity);
    }
    this.buscarTodos();
  }

  salvarImc(idUsuario, imcEntity) {
    this.imcService.save(idUsuario, imcEntity).subscribe(
      (imc) => {
        this.imcMensagem = this.verificaImc(imc);
        this.imcLista = [...this.imcLista, imc];
      },
      (error) => {
        this.error = error.error;
        console.error(error);
      }
    );
  }

  verificaImc(imc: Imc): object {
    if (imc.imc < 18.5) {
      return {
        tipo: "primary",
        texto: "Abaixo do peso",
      };
    } else if (imc.imc >= 18.5 && imc.imc <= 24.999) {
      return {
        tipo: "info",
        texto: "Peso normal",
      };
    } else if (imc.imc >= 25 && imc.imc <= 29.999) {
      return {
        tipo: "success",
        texto: "Sobrepeso",
      };
    } else if (imc.imc >= 30 && imc.imc <= 34.999) {
      return {
        tipo: "default",
        texto: "Obesidade grau I",
      };
    } else if (imc.imc >= 35 && imc.imc <= 39.9) {
      return {
        tipo: "warning",
        texto: "Obesidade grau II",
      };
    } else if (imc.imc >= 40) {
      return {
        tipo: "danger",
        texto: "Obesidade grau III",
      };
    }
  }
}
