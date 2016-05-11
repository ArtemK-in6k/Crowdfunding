describe('check save project', function () {

    var scope, ctrl, httpBackend, ControlDonatesService, Notification;

    beforeEach(module("crowdfundingApp.control"));

    beforeEach(
        inject(
            function ($controller, $rootScope, _ControlDonatesService_, _Notification_,$httpBackend) {
                httpBackend = $httpBackend;
                scope = $rootScope.$new();
                ControlDonatesService = _ControlDonatesService_;
                Notification = _Notification_;
                ctrl = $controller('OwnDonates', {
                    $scope: scope,
                    ControlDonatesService: ControlDonatesService,
                    Notification: Notification
                });
            }
        )
    );

    it('should be true', function () {

        ctrl.donates = [{
            "id": 100,
            "donate": 2222.0,
            "projectName": "434",
            "date": 1462883203930,
            "image": "http://www.fitnessandtennis.com/pages/baltimoreft/image/Tennis%20Racquet%20Picturejpg.jpg",
            "needAmount": 4444.0,
            "status": "COMPLETED",
            "donateAmount": 2222.0,
            "projectId": 53,
            "simpleStatus": "Completed",
            "percentDonateProject": 50.0
        }];

        var donation = {
            "id": ctrl.donates[0].donate.id,
            "donate": 200.00
        };

        ctrl.saveDonate(200.00, ctrl.donates[0]);

        httpBackend
            .whenPOST('/control/donates', donation)
            .respond(200, ["control/donates"]);

        httpBackend
            .whenGET('/control/donates/list')
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
