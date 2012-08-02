package acousticviewer



import org.junit.*
import grails.test.mixin.*

@TestFor(Anmn_Acoustic_SitesController)
@Mock(Anmn_Acoustic_Sites)
class Anmn_Acoustic_SitesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/anmn_Acoustic_Sites/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.anmn_Acoustic_SitesInstanceList.size() == 0
        assert model.anmn_Acoustic_SitesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.anmn_Acoustic_SitesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.anmn_Acoustic_SitesInstance != null
        assert view == '/anmn_Acoustic_Sites/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/anmn_Acoustic_Sites/show/1'
        assert controller.flash.message != null
        assert Anmn_Acoustic_Sites.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/anmn_Acoustic_Sites/list'

        populateValidParams(params)
        def anmn_Acoustic_Sites = new Anmn_Acoustic_Sites(params)

        assert anmn_Acoustic_Sites.save() != null

        params.id = anmn_Acoustic_Sites.id

        def model = controller.show()

        assert model.anmn_Acoustic_SitesInstance == anmn_Acoustic_Sites
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/anmn_Acoustic_Sites/list'

        populateValidParams(params)
        def anmn_Acoustic_Sites = new Anmn_Acoustic_Sites(params)

        assert anmn_Acoustic_Sites.save() != null

        params.id = anmn_Acoustic_Sites.id

        def model = controller.edit()

        assert model.anmn_Acoustic_SitesInstance == anmn_Acoustic_Sites
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/anmn_Acoustic_Sites/list'

        response.reset()

        populateValidParams(params)
        def anmn_Acoustic_Sites = new Anmn_Acoustic_Sites(params)

        assert anmn_Acoustic_Sites.save() != null

        // test invalid parameters in update
        params.id = anmn_Acoustic_Sites.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/anmn_Acoustic_Sites/edit"
        assert model.anmn_Acoustic_SitesInstance != null

        anmn_Acoustic_Sites.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/anmn_Acoustic_Sites/show/$anmn_Acoustic_Sites.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        anmn_Acoustic_Sites.clearErrors()

        populateValidParams(params)
        params.id = anmn_Acoustic_Sites.id
        params.version = -1
        controller.update()

        assert view == "/anmn_Acoustic_Sites/edit"
        assert model.anmn_Acoustic_SitesInstance != null
        assert model.anmn_Acoustic_SitesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/anmn_Acoustic_Sites/list'

        response.reset()

        populateValidParams(params)
        def anmn_Acoustic_Sites = new Anmn_Acoustic_Sites(params)

        assert anmn_Acoustic_Sites.save() != null
        assert Anmn_Acoustic_Sites.count() == 1

        params.id = anmn_Acoustic_Sites.id

        controller.delete()

        assert Anmn_Acoustic_Sites.count() == 0
        assert Anmn_Acoustic_Sites.get(anmn_Acoustic_Sites.id) == null
        assert response.redirectedUrl == '/anmn_Acoustic_Sites/list'
    }
}
