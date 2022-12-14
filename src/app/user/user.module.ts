import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserExperienceComponent } from './user-experience.component';
import { ProjectComponent } from '../project/project.component';
import { ProjectTechnologiesComponent } from '../project/technologies/technologies.component';
import { UserEducationComponent } from './user-education.component';
import { UserProfExpectationsComponent } from './user-prof-expectations.component';
import { UserSkillsHeaderComponent } from './user-skills-header.component';

import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { UserResolver } from './user-resolver.module';
import { PdfCompressorService } from '../pdf-compressor.service';
import { UserSkillsetComponent } from './user-skillset.component';
import { UserSettingsComponent } from '../user-settings/user-settings.component';
import { CVPageOneDirective } from '../cv-page-one.directive';
import { CVPageTwoDirective } from '../cv-page-two.directive';
import { CVPageThreeDirective } from '../cv-page-three.directive';
import { CVPageFourDirective } from '../cv-page-four.directive';
import { UserHeaderComponent } from './user-header.component';
import { UserEducationHeaderComponent } from './user-education-header.component';
import { UserFooterComponent } from './user-footer.component';
import { InlineEditorModule } from '@fradev/ngx-inline-editor';
import { TagInputModule } from 'ngx-chips';
import { ParametrizePipe } from '../core/parametrize.pipe';

@NgModule({

    imports: [
        CommonModule,
        FormsModule,
        UserRoutingModule,
        InlineEditorModule,
        TagInputModule
    ],
    declarations: [
        UserComponent,
        ProjectComponent,
        ProjectTechnologiesComponent,
        UserExperienceComponent,
        UserEducationComponent,
        UserProfExpectationsComponent,
        UserSkillsetComponent,
        UserSettingsComponent,
        CVPageOneDirective,
        CVPageTwoDirective,
        CVPageThreeDirective,
        CVPageFourDirective,
        UserHeaderComponent,
        UserEducationHeaderComponent,
        UserFooterComponent,
        UserSkillsHeaderComponent,
        ParametrizePipe
    ],
    providers: [
        UserResolver,
        PdfCompressorService
    ],
    entryComponents: [
        UserExperienceComponent,
        UserHeaderComponent,
        UserEducationComponent,
        UserEducationHeaderComponent,
        UserProfExpectationsComponent,
        UserFooterComponent,
        UserSkillsHeaderComponent,
        UserSkillsetComponent,
    ]
})
export class UserModule { }
