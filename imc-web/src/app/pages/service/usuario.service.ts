import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Usuario } from "../model/usuario.model";

@Injectable({
  providedIn: "root",
})
export class UsuarioService {
  public static readonly ENDPOINT = environment.api + "/usuario";

  constructor(private httpClient: HttpClient) {}

  save(
    usuario: Usuario
  ): Observable<Usuario> {
    return this.httpClient.post<Usuario>(
      UsuarioService.ENDPOINT,
      usuario
    );
  }
}
