SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

SRCREV     = "3b0b4e875c250dd0a36fdd3a3d124d907e9cc567"
SRC_URI[sha256sum] = "23c17ea5d0c59d6b9d304408259e83cec442c41d778b7e2ffb9dd1724479d4e2"
SRC_URI = "git://github.com/150manish/Yocto_check.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

DEPENDS = "virtual/libc libgcc"

RDEPENDS_${PN} = "libgcc"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -o hello code/hello.c -lpthread -lm
}

do_install () {
    install -d ${D}${bindir}
	install -m 0755 hello ${D}${bindir}
}

FILES_${PN} = "${bindir}/hello"