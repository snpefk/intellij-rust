package org.rust.lang.core.psi.ext

import org.rust.lang.core.symbols.RustPath

interface RsQualifiedNamedElement : RsNamedElement {
    val crateRelativePath: RustPath.CrateRelative?
}

val RsQualifiedNamedElement.qualifiedName: String? get() {
    val inCratePath = crateRelativePath ?: return null
    val cargoTarget = containingCargoTarget?.normName ?: return null
    return "$cargoTarget$inCratePath"
}