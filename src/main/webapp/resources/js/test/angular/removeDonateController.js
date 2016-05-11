describe('check save project', function () {

    var scope, ctrl, httpBackend, ControlDonatesService, ProjectDonatesService, Notification;

    beforeEach(module("crowdfundingApp.projects"));

    beforeEach(
        inject(
            function ($controller, $rootScope, _ControlDonatesService_, _ProjectDonatesService_, _Notification_,$httpBackend) {
                httpBackend = $httpBackend;
                scope = $rootScope.$new();
                ControlDonatesService = _ControlDonatesService_;
                ProjectDonatesService = _ProjectDonatesService_;
                Notification = _Notification_;
                ctrl = $controller('ProjectDetailsController', {
                    $scope: scope,
                    ControlDonatesService: ControlDonatesService,
                    ProjectDonatesService: ProjectDonatesService,
                    Notification: Notification
                });
            }
        )
    );

    it('should be remove project', function () {

        ctrl.projectsBeforeRemove = [{
            "id": 15,
            "userId": 3,
            "needAmount": 2500.0,
            "aboutProject": "<p style=\"color: rgb(37, 37, 37);background-color: rgb(255, 255, 255);\">Imagine a cardanic hinge –  that turns out to be the body of a ship, that axis ends up being the mast of said ship. Three spreaders rotate around it to provide balancing space for sailors, mice, bottles, crates. The spreaders are numbered (left or right to the mast, from five to ten), and the upper deck is divided into four quarters numbered 1-4. That's the set-up for<span class=\"Apple-converted-space\"> </span></p>",
            "image": "https://cf.geekdo-images.com/images/pic1214056.jpg",
            "donate_amount": 0.0,
            "date": "26-4-2016",
            "created": 1461674104058,
            "status": "COMPLETED",
            "nameProject": "Riff Raff",
            "categoryId": 0,
            "percentDonate": 0.0,
            "fullNameUser": "tt tt",
            "simpleStatus": "Completed"
        }];

        ctrl.deleteDonate(1, ctrl.projectsBeforeRemove[0]);

        httpBackend
            .whenDELETE('/control/donates/' + 1)
            .respond(200, {success: 'true'});

        httpBackend
            .whenGET('/api/projects/' + project.id + '/donates')
            .respond(200, [{
                "id": 100,
                "donate": 2422.0,
                "projectName": "434",
                "date": 1462883203930,
                "image": "http://www.fitnessandtennis.com/pages/baltimoreft/image/Tennis%20Racquet%20Picturejpg.jpg",
                "needAmount": 4444.0,
                "status": "COMPLETED",
                "donateAmount": 2422.0,
                "projectId": 53,
                "simpleStatus": "Completed",
                "percentDonateProject": 50.0
            }]);

        expect(ctrl.donates[0].donate).toBe(2422);
    });
});
