package acousticviewer



import org.junit.*
import grails.test.mixin.*

@TestFor(Acoustic_DeploymentsController)
@Mock(Acoustic_Deployments)
class Acoustic_DeploymentsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/acoustic_Deployments/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.acoustic_DeploymentsInstanceList.size() == 0
        assert model.acoustic_DeploymentsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.acoustic_DeploymentsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.acoustic_DeploymentsInstance != null
        assert view == '/acoustic_Deployments/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/acoustic_Deployments/show/1'
        assert controller.flash.message != null
        assert Acoustic_Deployments.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/acoustic_Deployments/list'

        populateValidParams(params)
        def acoustic_Deployments = new Acoustic_Deployments(params)

        assert acoustic_Deployments.save() != null

        params.id = acoustic_Deployments.id

        def model = controller.show()

        assert model.acoustic_DeploymentsInstance == acoustic_Deployments
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/acoustic_Deployments/list'

        populateValidParams(params)
        def acoustic_Deployments = new Acoustic_Deployments(params)

        assert acoustic_Deployments.save() != null

        params.id = acoustic_Deployments.id

        def model = controller.edit()

        assert model.acoustic_DeploymentsInstance == acoustic_Deployments
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/acoustic_Deployments/list'

        response.reset()

        populateValidParams(params)
        def acoustic_Deployments = new Acoustic_Deployments(params)

        assert acoustic_Deployments.save() != null

        // test invalid parameters in update
        params.id = acoustic_Deployments.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/acoustic_Deployments/edit"
        assert model.acoustic_DeploymentsInstance != null

        acoustic_Deployments.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/acoustic_Deployments/show/$acoustic_Deployments.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        acoustic_Deployments.clearErrors()

        populateValidParams(params)
        params.id = acoustic_Deployments.id
        params.version = -1
        controller.update()

        assert view == "/acoustic_Deployments/edit"
        assert model.acoustic_DeploymentsInstance != null
        assert model.acoustic_DeploymentsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/acoustic_Deployments/list'

        response.reset()

        populateValidParams(params)
        def acoustic_Deployments = new Acoustic_Deployments(params)

        assert acoustic_Deployments.save() != null
        assert Acoustic_Deployments.count() == 1

        params.id = acoustic_Deployments.id

        controller.delete()

        assert Acoustic_Deployments.count() == 0
        assert Acoustic_Deployments.get(acoustic_Deployments.id) == null
        assert response.redirectedUrl == '/acoustic_Deployments/list'
    }
}
