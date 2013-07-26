/*
 * Copyright 2013 IMOS
 *
 * The AODN/IMOS Portal is distributed under the terms of the GNU General Public License
 *
 */

package acousticviewer

import org.springframework.dao.DataIntegrityViolationException

class Acoustic_DeploymentsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }	

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [acoustic_DeploymentsInstanceList: Acoustic_Deployments.list(params), acoustic_DeploymentsInstanceTotal: Acoustic_Deployments.count()]
    }

    def create() {
        [acoustic_DeploymentsInstance: new Acoustic_Deployments(params)]
    }

    def save() {
        def acoustic_DeploymentsInstance = new Acoustic_Deployments(params)
        if (!acoustic_DeploymentsInstance.save(flush: true)) {
            render(view: "create", model: [acoustic_DeploymentsInstance: acoustic_DeploymentsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), acoustic_DeploymentsInstance.id])
        redirect(action: "show", id: acoustic_DeploymentsInstance.id)
    }

    def show(Long id) {
        def acoustic_DeploymentsInstance = Acoustic_Deployments.get(id)
        if (!acoustic_DeploymentsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), id])
            redirect(action: "list")
            return
        }

        [acoustic_DeploymentsInstance: acoustic_DeploymentsInstance]
    }

    def edit(Long id) {
        def acoustic_DeploymentsInstance = Acoustic_Deployments.get(id)
        if (!acoustic_DeploymentsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), id])
            redirect(action: "list")
            return
        }

        [acoustic_DeploymentsInstance: acoustic_DeploymentsInstance]
    }

    def update(Long id, Long version) {
        def acoustic_DeploymentsInstance = Acoustic_Deployments.get(id)
        if (!acoustic_DeploymentsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (acoustic_DeploymentsInstance.version > version) {
                acoustic_DeploymentsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments')] as Object[],
                          "Another user has updated this Acoustic_Deployments while you were editing")
                render(view: "edit", model: [acoustic_DeploymentsInstance: acoustic_DeploymentsInstance])
                return
            }
        }

        acoustic_DeploymentsInstance.properties = params

        if (!acoustic_DeploymentsInstance.save(flush: true)) {
            render(view: "edit", model: [acoustic_DeploymentsInstance: acoustic_DeploymentsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), acoustic_DeploymentsInstance.id])
        redirect(action: "show", id: acoustic_DeploymentsInstance.id)
    }

    def delete(Long id) {
        def acoustic_DeploymentsInstance = Acoustic_Deployments.get(id)
        if (!acoustic_DeploymentsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), id])
            redirect(action: "list")
            return
        }

        try {
            acoustic_DeploymentsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'acoustic_Deployments.label', default: 'Acoustic_Deployments'), id])
            redirect(action: "show", id: id)
        }
    }
}
