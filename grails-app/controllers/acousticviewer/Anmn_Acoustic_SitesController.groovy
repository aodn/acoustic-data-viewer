package acousticviewer

import org.springframework.dao.DataIntegrityViolationException

class Anmn_Acoustic_SitesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [anmn_Acoustic_SitesInstanceList: Anmn_Acoustic_Sites.list(params), anmn_Acoustic_SitesInstanceTotal: Anmn_Acoustic_Sites.count()]
    }

    def create() {
        [anmn_Acoustic_SitesInstance: new Anmn_Acoustic_Sites(params)]
    }

    def save() {
        def anmn_Acoustic_SitesInstance = new Anmn_Acoustic_Sites(params)
        if (!anmn_Acoustic_SitesInstance.save(flush: true)) {
            render(view: "create", model: [anmn_Acoustic_SitesInstance: anmn_Acoustic_SitesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), anmn_Acoustic_SitesInstance.id])
        redirect(action: "show", id: anmn_Acoustic_SitesInstance.id)
    }

    def show(Long id) {
        def anmn_Acoustic_SitesInstance = Anmn_Acoustic_Sites.get(id)
        if (!anmn_Acoustic_SitesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), id])
            redirect(action: "list")
            return
        }

        [anmn_Acoustic_SitesInstance: anmn_Acoustic_SitesInstance]
    }

    def edit(Long id) {
        def anmn_Acoustic_SitesInstance = Anmn_Acoustic_Sites.get(id)
        if (!anmn_Acoustic_SitesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), id])
            redirect(action: "list")
            return
        }

        [anmn_Acoustic_SitesInstance: anmn_Acoustic_SitesInstance]
    }

    def update(Long id, Long version) {
        def anmn_Acoustic_SitesInstance = Anmn_Acoustic_Sites.get(id)
        if (!anmn_Acoustic_SitesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (anmn_Acoustic_SitesInstance.version > version) {
                anmn_Acoustic_SitesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites')] as Object[],
                          "Another user has updated this Anmn_Acoustic_Sites while you were editing")
                render(view: "edit", model: [anmn_Acoustic_SitesInstance: anmn_Acoustic_SitesInstance])
                return
            }
        }

        anmn_Acoustic_SitesInstance.properties = params

        if (!anmn_Acoustic_SitesInstance.save(flush: true)) {
            render(view: "edit", model: [anmn_Acoustic_SitesInstance: anmn_Acoustic_SitesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), anmn_Acoustic_SitesInstance.id])
        redirect(action: "show", id: anmn_Acoustic_SitesInstance.id)
    }

    def delete(Long id) {
        def anmn_Acoustic_SitesInstance = Anmn_Acoustic_Sites.get(id)
        if (!anmn_Acoustic_SitesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), id])
            redirect(action: "list")
            return
        }

        try {
            anmn_Acoustic_SitesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'anmn_Acoustic_Sites.label', default: 'Anmn_Acoustic_Sites'), id])
            redirect(action: "show", id: id)
        }
    }
}
