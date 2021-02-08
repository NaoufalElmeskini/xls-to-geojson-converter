import { Component, OnInit } from '@angular/core';
import {FileService} from "../file.service";

@Component({
  selector: 'app-action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.css']
})
export class ActionComponent implements OnInit {
  private fichierAEnvoyer: File = null;

  constructor(private fileService: FileService) { }

  ngOnInit() {
  }

  chargerFichier (fichiers: FileList) {
    this.fichierAEnvoyer = fichiers.item(0);
    console.log('fichier chargé: ');
    console.log(fichiers);
  }


  envoyerFichier() {
    console.log('fichier envoyé:');
    console.log(this.fichierAEnvoyer);
    this.fileService.traiterFichier(this.fichierAEnvoyer)
  }
}
