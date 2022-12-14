import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';

@Component({
    selector: 'app-project-technologies',
    templateUrl: './technologies.component.html',
    styleUrls: ['./technologies.component.css']
})
export class ProjectTechnologiesComponent implements OnInit {

    @Input() technologies: any;
    @Output() updateTechnologies = new EventEmitter<any>();
    @Output() onSave = new EventEmitter<any>();
    editing = false;
    currentTechnologies;

    constructor() { }

    ngOnInit() {
        this.currentTechnologies = this.technologies;
    }

    enableInline() {
        this.editing = !this.editing;
    }

    saveTechnologies() {
        this.editing = !this.editing;
        this.currentTechnologies = this.prepareSkills(this.currentTechnologies );
        this.onSave.emit(this.currentTechnologies);
    }

    cancelEdit() {
        this.editing = !this.editing;
        this.currentTechnologies = this.technologies;
    }

    prepareSkills(skill): Array<any> {
        const cleanCopy = [];
        skill.forEach(name => {
            if (typeof name === 'string') {
            cleanCopy.push(name);
            } else {
            cleanCopy.push(name.value);
            }
        });
        return cleanCopy;
    }

}
