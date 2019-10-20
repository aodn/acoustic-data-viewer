#!/usr/bin/env bash

set -eux

RELEASE_BRANCH=master

bumpversion_build() {
  bump2version patch
}

bumpversion_release() {
  bump2version patch
  VERSION=$(bump2version --list --commit --allow-dirty release | grep -oP '^new_version=\K.*$')
  git fetch origin
  git reset --hard origin/$RELEASE_BRANCH
  git tag -a -f -m 'Jenkins: create tag $VERSION' $VERSION
  git push origin tag $VERSION

}

main() {
  local mode=$1; shift

  if [ "x${mode}" == "xbuild" ]
  then
    bumpversion_build
  elif [ "x${mode}" == "xrelease" ]
  then
    bumpversion_release
  fi

  exit 0
}

main "$@"
