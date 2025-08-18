@file:Suppress("EXPERIMENTAL_API_USAGE","EXPERIMENTAL_UNSIGNED_LITERALS","PackageDirectoryMismatch","UnusedImport","unused","LocalVariableName","CanBeVal","PropertyName","EnumEntryName","ClassName","ObjectPropertyName","UnnecessaryVariable","SpellCheckingInspection")
package com.microsoft.tfs.model.connector

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.*
import com.jetbrains.rd.framework.impl.*

import com.jetbrains.rd.util.lifetime.*
import com.jetbrains.rd.util.reactive.*
import com.jetbrains.rd.util.string.*
import com.jetbrains.rd.util.*
import kotlin.time.Duration
import kotlin.reflect.KClass
import kotlin.jvm.JvmStatic
import java.net.URI



/**
 * #### Generated from [TfsModel.kt:10]
 */
class TfsModel private constructor(
    private val _shutdown: RdSignal<Unit>,
    private val _collections: RdMap<TfsCollectionDefinition, TfsCollection>,
    private val _getBasicWorkspaceInfo: RdCall<TfsLocalPath, TfsWorkspaceInfo?>,
    private val _getDetailedWorkspaceInfo: RdCall<TfsDetailedWorkspaceRequest, TfsDetailedWorkspaceInfo?>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(TfsLocalPath)
            serializers.register(TfsServerPath)
            serializers.register(TfsServerStatusType.marshaller)
            serializers.register(TfsPendingChange)
            serializers.register(TfsCredentials)
            serializers.register(TfsCollectionDefinition)
            serializers.register(TfsLocalItemInfo)
            serializers.register(TfsExtendedItemInfo)
            serializers.register(TfsDeleteResult)
            serializers.register(TfvcCheckoutParameters)
            serializers.register(TfvcCheckoutResult)
            serializers.register(TfvcRenameRequest)
            serializers.register(TfsCollection)
            serializers.register(TfsWorkspaceMapping)
            serializers.register(TfsBasicWorkspaceInfo)
            serializers.register(TfsDetailedWorkspaceInfo)
            serializers.register(TfsDetailedWorkspaceRequest)
            serializers.register(TfsPath_Unknown)
            serializers.register(TfsItemInfo_Unknown)
            serializers.register(TfsWorkspaceInfo_Unknown)
            TfsModel.register(serializers)
        }
        
        @JvmStatic
        fun create(lifetime: Lifetime, protocol: IProtocol): TfsModel {
            return TfsModel().apply {
                identify(protocol.identity, RdId.Null)
                bind(lifetime, protocol, "TfsModel")
            }
        }
        
        
        
        
        private val __TfsWorkspaceInfoNullableSerializer = AbstractPolymorphic(TfsWorkspaceInfo).nullable()
        private val __TfsDetailedWorkspaceInfoNullableSerializer = TfsDetailedWorkspaceInfo.nullable()
        
        const val serializationHash = -3592840572825528740L
        
    }
    override val serializersOwner: ISerializersOwner get() = TfsModel
    override val serializationHash: Long get() = TfsModel.serializationHash
    
    //fields
    
    /**
     * Shuts down the application
     */
    val shutdown: ISignal<Unit> get() = _shutdown
    val collections: IMutableViewableMap<TfsCollectionDefinition, TfsCollection> get() = _collections
    val getBasicWorkspaceInfo: IRdCall<TfsLocalPath, TfsWorkspaceInfo?> get() = _getBasicWorkspaceInfo
    val getDetailedWorkspaceInfo: IRdCall<TfsDetailedWorkspaceRequest, TfsDetailedWorkspaceInfo?> get() = _getDetailedWorkspaceInfo
    
    //methods
    //initializer
    init {
        bindableChildren.add("shutdown" to _shutdown)
        bindableChildren.add("collections" to _collections)
        bindableChildren.add("getBasicWorkspaceInfo" to _getBasicWorkspaceInfo)
        bindableChildren.add("getDetailedWorkspaceInfo" to _getDetailedWorkspaceInfo)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdSignal<Unit>(FrameworkMarshallers.Void),
        RdMap<TfsCollectionDefinition, TfsCollection>(TfsCollectionDefinition, TfsCollection),
        RdCall<TfsLocalPath, TfsWorkspaceInfo?>(TfsLocalPath, __TfsWorkspaceInfoNullableSerializer),
        RdCall<TfsDetailedWorkspaceRequest, TfsDetailedWorkspaceInfo?>(TfsDetailedWorkspaceRequest, __TfsDetailedWorkspaceInfoNullableSerializer)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsModel (")
        printer.indent {
            print("shutdown = "); _shutdown.print(printer); println()
            print("collections = "); _collections.print(printer); println()
            print("getBasicWorkspaceInfo = "); _getBasicWorkspaceInfo.print(printer); println()
            print("getDetailedWorkspaceInfo = "); _getDetailedWorkspaceInfo.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): TfsModel   {
        return TfsModel(
            _shutdown.deepClonePolymorphic(),
            _collections.deepClonePolymorphic(),
            _getBasicWorkspaceInfo.deepClonePolymorphic(),
            _getDetailedWorkspaceInfo.deepClonePolymorphic()
        )
    }
    //contexts
    //threading  
    // Note: ExtThreadingKind removed in newer RD versions
}


/**
 * #### Generated from [TfsModel.kt:144]
 */
class TfsBasicWorkspaceInfo (
    serverUri: String,
    workspaceName: String
) : TfsWorkspaceInfo (
    serverUri,
    workspaceName
) {
    //companion
    
    companion object : IMarshaller<TfsBasicWorkspaceInfo> {
        override val _type: KClass<TfsBasicWorkspaceInfo> = TfsBasicWorkspaceInfo::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsBasicWorkspaceInfo  {
            val serverUri = buffer.readString()
            val workspaceName = buffer.readString()
            return TfsBasicWorkspaceInfo(serverUri, workspaceName)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsBasicWorkspaceInfo)  {
            buffer.writeString(value.serverUri)
            buffer.writeString(value.workspaceName)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsBasicWorkspaceInfo
        
        if (serverUri != other.serverUri) return false
        if (workspaceName != other.workspaceName) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + serverUri.hashCode()
        __r = __r*31 + workspaceName.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsBasicWorkspaceInfo (")
        printer.indent {
            print("serverUri = "); serverUri.print(printer); println()
            print("workspaceName = "); workspaceName.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:98]
 */
class TfsCollection private constructor(
    private val _isReady: RdOptionalProperty<Boolean>,
    private val _mappedPaths: RdOptionalProperty<List<TfsPath>>,
    private val _getPendingChanges: RdCall<List<TfsPath>, List<TfsPendingChange>>,
    private val _getLocalItemsInfo: RdCall<List<TfsLocalPath>, List<TfsLocalItemInfo>>,
    private val _getExtendedLocalItemsInfo: RdCall<List<TfsLocalPath>, List<TfsExtendedItemInfo>>,
    private val _invalidatePaths: RdCall<List<TfsLocalPath>, Unit>,
    private val _addFiles: RdCall<List<TfsLocalPath>, List<TfsLocalPath>>,
    private val _deleteFilesRecursively: RdCall<List<TfsPath>, TfsDeleteResult>,
    private val _undoLocalChanges: RdCall<List<TfsPath>, List<TfsLocalPath>>,
    private val _checkoutFilesForEdit: RdCall<TfvcCheckoutParameters, TfvcCheckoutResult>,
    private val _renameFile: RdCall<TfvcRenameRequest, Boolean>
) : RdBindableBase() {
    //companion
    
    companion object : IMarshaller<TfsCollection> {
        override val _type: KClass<TfsCollection> = TfsCollection::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsCollection  {
            val _id = RdId.read(buffer)
            val _isReady = RdOptionalProperty.read(ctx, buffer, FrameworkMarshallers.Bool)
            val _mappedPaths = RdOptionalProperty.read(ctx, buffer, __TfsPathListSerializer)
            val _getPendingChanges = RdCall.read(ctx, buffer, __TfsPathListSerializer, __TfsPendingChangeListSerializer)
            val _getLocalItemsInfo = RdCall.read(ctx, buffer, __TfsLocalPathListSerializer, __TfsLocalItemInfoListSerializer)
            val _getExtendedLocalItemsInfo = RdCall.read(ctx, buffer, __TfsLocalPathListSerializer, __TfsExtendedItemInfoListSerializer)
            val _invalidatePaths = RdCall.read(ctx, buffer, __TfsLocalPathListSerializer, FrameworkMarshallers.Void)
            val _addFiles = RdCall.read(ctx, buffer, __TfsLocalPathListSerializer, __TfsLocalPathListSerializer)
            val _deleteFilesRecursively = RdCall.read(ctx, buffer, __TfsPathListSerializer, TfsDeleteResult)
            val _undoLocalChanges = RdCall.read(ctx, buffer, __TfsPathListSerializer, __TfsLocalPathListSerializer)
            val _checkoutFilesForEdit = RdCall.read(ctx, buffer, TfvcCheckoutParameters, TfvcCheckoutResult)
            val _renameFile = RdCall.read(ctx, buffer, TfvcRenameRequest, FrameworkMarshallers.Bool)
            return TfsCollection(_isReady, _mappedPaths, _getPendingChanges, _getLocalItemsInfo, _getExtendedLocalItemsInfo, _invalidatePaths, _addFiles, _deleteFilesRecursively, _undoLocalChanges, _checkoutFilesForEdit, _renameFile).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsCollection)  {
            value.rdid.write(buffer)
            RdOptionalProperty.write(ctx, buffer, value._isReady)
            RdOptionalProperty.write(ctx, buffer, value._mappedPaths)
            RdCall.write(ctx, buffer, value._getPendingChanges)
            RdCall.write(ctx, buffer, value._getLocalItemsInfo)
            RdCall.write(ctx, buffer, value._getExtendedLocalItemsInfo)
            RdCall.write(ctx, buffer, value._invalidatePaths)
            RdCall.write(ctx, buffer, value._addFiles)
            RdCall.write(ctx, buffer, value._deleteFilesRecursively)
            RdCall.write(ctx, buffer, value._undoLocalChanges)
            RdCall.write(ctx, buffer, value._checkoutFilesForEdit)
            RdCall.write(ctx, buffer, value._renameFile)
        }
        
        private val __TfsPathListSerializer = AbstractPolymorphic(TfsPath).list()
        private val __TfsPendingChangeListSerializer = TfsPendingChange.list()
        private val __TfsLocalPathListSerializer = TfsLocalPath.list()
        private val __TfsLocalItemInfoListSerializer = TfsLocalItemInfo.list()
        private val __TfsExtendedItemInfoListSerializer = TfsExtendedItemInfo.list()
        
    }
    //fields
    
    /**
     * Whether the client is ready to accept method calls
     */
    val isReady: IOptProperty<Boolean> get() = _isReady
    
    /**
     * A list of path mappings for this collection
     */
    val mappedPaths: IOptProperty<List<TfsPath>> get() = _mappedPaths
    
    /**
     * Determines a set of the pending changes in the collection
     */
    val getPendingChanges: IRdCall<List<TfsPath>, List<TfsPendingChange>> get() = _getPendingChanges
    
    /**
     * Provides information on local repository items
     */
    val getLocalItemsInfo: IRdCall<List<TfsLocalPath>, List<TfsLocalItemInfo>> get() = _getLocalItemsInfo
    
    /**
     * Provides extended information (i.e. including locks) on local repository items
     */
    val getExtendedLocalItemsInfo: IRdCall<List<TfsLocalPath>, List<TfsExtendedItemInfo>> get() = _getExtendedLocalItemsInfo
    
    /**
     * Invalidates the paths in the TFS cache
     */
    val invalidatePaths: IRdCall<List<TfsLocalPath>, Unit> get() = _invalidatePaths
    
    /**
     * Creates an "add" pending change, which adds files and folders from the local workspace to the source control server. Returns a collection of the paths added.
     */
    val addFiles: IRdCall<List<TfsLocalPath>, List<TfsLocalPath>> get() = _addFiles
    
    /**
     * Scheduled deletion of the files
     */
    val deleteFilesRecursively: IRdCall<List<TfsPath>, TfsDeleteResult> get() = _deleteFilesRecursively
    
    /**
     * Removes pending changes from a workspace, restoring the local disk files to match the state of the source control server before the change was made.
     */
    val undoLocalChanges: IRdCall<List<TfsPath>, List<TfsLocalPath>> get() = _undoLocalChanges
    
    /**
     * Makes one or more local files writable and creates "edit" pending changes for them in the current workspace.
     */
    val checkoutFilesForEdit: IRdCall<TfvcCheckoutParameters, TfvcCheckoutResult> get() = _checkoutFilesForEdit
    
    /**
     * Creates a "rename" pending change, which moves or renames a file or folder. Returns success status
     */
    val renameFile: IRdCall<TfvcRenameRequest, Boolean> get() = _renameFile
    //methods
    //initializer
    init {
        _isReady.optimizeNested = true
        _mappedPaths.optimizeNested = true
    }
    
    init {
        bindableChildren.add("isReady" to _isReady)
        bindableChildren.add("mappedPaths" to _mappedPaths)
        bindableChildren.add("getPendingChanges" to _getPendingChanges)
        bindableChildren.add("getLocalItemsInfo" to _getLocalItemsInfo)
        bindableChildren.add("getExtendedLocalItemsInfo" to _getExtendedLocalItemsInfo)
        bindableChildren.add("invalidatePaths" to _invalidatePaths)
        bindableChildren.add("addFiles" to _addFiles)
        bindableChildren.add("deleteFilesRecursively" to _deleteFilesRecursively)
        bindableChildren.add("undoLocalChanges" to _undoLocalChanges)
        bindableChildren.add("checkoutFilesForEdit" to _checkoutFilesForEdit)
        bindableChildren.add("renameFile" to _renameFile)
    }
    
    //secondary constructor
    constructor(
    ) : this(
        RdOptionalProperty<Boolean>(FrameworkMarshallers.Bool),
        RdOptionalProperty<List<TfsPath>>(__TfsPathListSerializer),
        RdCall<List<TfsPath>, List<TfsPendingChange>>(__TfsPathListSerializer, __TfsPendingChangeListSerializer),
        RdCall<List<TfsLocalPath>, List<TfsLocalItemInfo>>(__TfsLocalPathListSerializer, __TfsLocalItemInfoListSerializer),
        RdCall<List<TfsLocalPath>, List<TfsExtendedItemInfo>>(__TfsLocalPathListSerializer, __TfsExtendedItemInfoListSerializer),
        RdCall<List<TfsLocalPath>, Unit>(__TfsLocalPathListSerializer, FrameworkMarshallers.Void),
        RdCall<List<TfsLocalPath>, List<TfsLocalPath>>(__TfsLocalPathListSerializer, __TfsLocalPathListSerializer),
        RdCall<List<TfsPath>, TfsDeleteResult>(__TfsPathListSerializer, TfsDeleteResult),
        RdCall<List<TfsPath>, List<TfsLocalPath>>(__TfsPathListSerializer, __TfsLocalPathListSerializer),
        RdCall<TfvcCheckoutParameters, TfvcCheckoutResult>(TfvcCheckoutParameters, TfvcCheckoutResult),
        RdCall<TfvcRenameRequest, Boolean>(TfvcRenameRequest, FrameworkMarshallers.Bool)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsCollection (")
        printer.indent {
            print("isReady = "); _isReady.print(printer); println()
            print("mappedPaths = "); _mappedPaths.print(printer); println()
            print("getPendingChanges = "); _getPendingChanges.print(printer); println()
            print("getLocalItemsInfo = "); _getLocalItemsInfo.print(printer); println()
            print("getExtendedLocalItemsInfo = "); _getExtendedLocalItemsInfo.print(printer); println()
            print("invalidatePaths = "); _invalidatePaths.print(printer); println()
            print("addFiles = "); _addFiles.print(printer); println()
            print("deleteFilesRecursively = "); _deleteFilesRecursively.print(printer); println()
            print("undoLocalChanges = "); _undoLocalChanges.print(printer); println()
            print("checkoutFilesForEdit = "); _checkoutFilesForEdit.print(printer); println()
            print("renameFile = "); _renameFile.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): TfsCollection   {
        return TfsCollection(
            _isReady.deepClonePolymorphic(),
            _mappedPaths.deepClonePolymorphic(),
            _getPendingChanges.deepClonePolymorphic(),
            _getLocalItemsInfo.deepClonePolymorphic(),
            _getExtendedLocalItemsInfo.deepClonePolymorphic(),
            _invalidatePaths.deepClonePolymorphic(),
            _addFiles.deepClonePolymorphic(),
            _deleteFilesRecursively.deepClonePolymorphic(),
            _undoLocalChanges.deepClonePolymorphic(),
            _checkoutFilesForEdit.deepClonePolymorphic(),
            _renameFile.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:53]
 */
data class TfsCollectionDefinition (
    val serverUri: URI,
    val credentials: TfsCredentials
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfsCollectionDefinition> {
        override val _type: KClass<TfsCollectionDefinition> = TfsCollectionDefinition::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsCollectionDefinition  {
            val serverUri = buffer.readUri()
            val credentials = TfsCredentials.read(ctx, buffer)
            return TfsCollectionDefinition(serverUri, credentials)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsCollectionDefinition)  {
            buffer.writeUri(value.serverUri)
            TfsCredentials.write(ctx, buffer, value.credentials)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsCollectionDefinition
        
        if (serverUri != other.serverUri) return false
        if (credentials != other.credentials) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + serverUri.hashCode()
        __r = __r*31 + credentials.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsCollectionDefinition (")
        printer.indent {
            print("serverUri = "); serverUri.print(printer); println()
            print("credentials = "); credentials.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:48]
 */
data class TfsCredentials (
    val login: String,
    val password: RdSecureString
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfsCredentials> {
        override val _type: KClass<TfsCredentials> = TfsCredentials::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsCredentials  {
            val login = buffer.readString()
            val password = buffer.readSecureString()
            return TfsCredentials(login, password)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsCredentials)  {
            buffer.writeString(value.login)
            buffer.writeSecureString(value.password)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsCredentials
        
        if (login != other.login) return false
        if (password != other.password) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + login.hashCode()
        __r = __r*31 + password.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsCredentials (")
        printer.indent {
            print("login = "); login.print(printer); println()
            print("password = "); password.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:76]
 */
data class TfsDeleteResult (
    val deletedPaths: List<TfsLocalPath>,
    val notFoundPaths: List<TfsPath>,
    val errorMessages: List<String>
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfsDeleteResult> {
        override val _type: KClass<TfsDeleteResult> = TfsDeleteResult::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsDeleteResult  {
            val deletedPaths = buffer.readList { TfsLocalPath.read(ctx, buffer) }
            val notFoundPaths = buffer.readList { ctx.serializers.readPolymorphic<TfsPath>(ctx, buffer, TfsPath) }
            val errorMessages = buffer.readList { buffer.readString() }
            return TfsDeleteResult(deletedPaths, notFoundPaths, errorMessages)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsDeleteResult)  {
            buffer.writeList(value.deletedPaths) { v -> TfsLocalPath.write(ctx, buffer, v) }
            buffer.writeList(value.notFoundPaths) { v -> ctx.serializers.writePolymorphic(ctx, buffer, v) }
            buffer.writeList(value.errorMessages) { v -> buffer.writeString(v) }
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsDeleteResult
        
        if (deletedPaths != other.deletedPaths) return false
        if (notFoundPaths != other.notFoundPaths) return false
        if (errorMessages != other.errorMessages) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + deletedPaths.hashCode()
        __r = __r*31 + notFoundPaths.hashCode()
        __r = __r*31 + errorMessages.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsDeleteResult (")
        printer.indent {
            print("deletedPaths = "); deletedPaths.print(printer); println()
            print("notFoundPaths = "); notFoundPaths.print(printer); println()
            print("errorMessages = "); errorMessages.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:146]
 */
class TfsDetailedWorkspaceInfo (
    val mappings: List<TfsWorkspaceMapping>,
    serverUri: String,
    workspaceName: String
) : TfsWorkspaceInfo (
    serverUri,
    workspaceName
) {
    //companion
    
    companion object : IMarshaller<TfsDetailedWorkspaceInfo> {
        override val _type: KClass<TfsDetailedWorkspaceInfo> = TfsDetailedWorkspaceInfo::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsDetailedWorkspaceInfo  {
            val serverUri = buffer.readString()
            val workspaceName = buffer.readString()
            val mappings = buffer.readList { TfsWorkspaceMapping.read(ctx, buffer) }
            return TfsDetailedWorkspaceInfo(mappings, serverUri, workspaceName)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsDetailedWorkspaceInfo)  {
            buffer.writeString(value.serverUri)
            buffer.writeString(value.workspaceName)
            buffer.writeList(value.mappings) { v -> TfsWorkspaceMapping.write(ctx, buffer, v) }
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsDetailedWorkspaceInfo
        
        if (mappings != other.mappings) return false
        if (serverUri != other.serverUri) return false
        if (workspaceName != other.workspaceName) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + mappings.hashCode()
        __r = __r*31 + serverUri.hashCode()
        __r = __r*31 + workspaceName.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsDetailedWorkspaceInfo (")
        printer.indent {
            print("mappings = "); mappings.print(printer); println()
            print("serverUri = "); serverUri.print(printer); println()
            print("workspaceName = "); workspaceName.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:150]
 */
data class TfsDetailedWorkspaceRequest (
    val credentials: TfsCredentials,
    val workspacePath: TfsLocalPath
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfsDetailedWorkspaceRequest> {
        override val _type: KClass<TfsDetailedWorkspaceRequest> = TfsDetailedWorkspaceRequest::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsDetailedWorkspaceRequest  {
            val credentials = TfsCredentials.read(ctx, buffer)
            val workspacePath = TfsLocalPath.read(ctx, buffer)
            return TfsDetailedWorkspaceRequest(credentials, workspacePath)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsDetailedWorkspaceRequest)  {
            TfsCredentials.write(ctx, buffer, value.credentials)
            TfsLocalPath.write(ctx, buffer, value.workspacePath)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsDetailedWorkspaceRequest
        
        if (credentials != other.credentials) return false
        if (workspacePath != other.workspacePath) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + credentials.hashCode()
        __r = __r*31 + workspacePath.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsDetailedWorkspaceRequest (")
        printer.indent {
            print("credentials = "); credentials.print(printer); println()
            print("workspacePath = "); workspacePath.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:71]
 */
class TfsExtendedItemInfo (
    val lock: String?,
    val lockOwner: String?,
    serverItem: String?,
    localItem: String?,
    localVersion: Int,
    serverVersion: Int,
    change: String?,
    type: String?,
    lastModified: String?,
    fileEncoding: String?
) : TfsItemInfo (
    serverItem,
    localItem,
    localVersion,
    serverVersion,
    change,
    type,
    lastModified,
    fileEncoding
) {
    //companion
    
    companion object : IMarshaller<TfsExtendedItemInfo> {
        override val _type: KClass<TfsExtendedItemInfo> = TfsExtendedItemInfo::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsExtendedItemInfo  {
            val serverItem = buffer.readNullable { buffer.readString() }
            val localItem = buffer.readNullable { buffer.readString() }
            val localVersion = buffer.readInt()
            val serverVersion = buffer.readInt()
            val change = buffer.readNullable { buffer.readString() }
            val type = buffer.readNullable { buffer.readString() }
            val lastModified = buffer.readNullable { buffer.readString() }
            val fileEncoding = buffer.readNullable { buffer.readString() }
            val lock = buffer.readNullable { buffer.readString() }
            val lockOwner = buffer.readNullable { buffer.readString() }
            return TfsExtendedItemInfo(lock, lockOwner, serverItem, localItem, localVersion, serverVersion, change, type, lastModified, fileEncoding)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsExtendedItemInfo)  {
            buffer.writeNullable(value.serverItem) { buffer.writeString(it) }
            buffer.writeNullable(value.localItem) { buffer.writeString(it) }
            buffer.writeInt(value.localVersion)
            buffer.writeInt(value.serverVersion)
            buffer.writeNullable(value.change) { buffer.writeString(it) }
            buffer.writeNullable(value.type) { buffer.writeString(it) }
            buffer.writeNullable(value.lastModified) { buffer.writeString(it) }
            buffer.writeNullable(value.fileEncoding) { buffer.writeString(it) }
            buffer.writeNullable(value.lock) { buffer.writeString(it) }
            buffer.writeNullable(value.lockOwner) { buffer.writeString(it) }
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsExtendedItemInfo
        
        if (lock != other.lock) return false
        if (lockOwner != other.lockOwner) return false
        if (serverItem != other.serverItem) return false
        if (localItem != other.localItem) return false
        if (localVersion != other.localVersion) return false
        if (serverVersion != other.serverVersion) return false
        if (change != other.change) return false
        if (type != other.type) return false
        if (lastModified != other.lastModified) return false
        if (fileEncoding != other.fileEncoding) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + if (lock != null) lock.hashCode() else 0
        __r = __r*31 + if (lockOwner != null) lockOwner.hashCode() else 0
        __r = __r*31 + if (serverItem != null) serverItem.hashCode() else 0
        __r = __r*31 + if (localItem != null) localItem.hashCode() else 0
        __r = __r*31 + localVersion.hashCode()
        __r = __r*31 + serverVersion.hashCode()
        __r = __r*31 + if (change != null) change.hashCode() else 0
        __r = __r*31 + if (type != null) type.hashCode() else 0
        __r = __r*31 + if (lastModified != null) lastModified.hashCode() else 0
        __r = __r*31 + if (fileEncoding != null) fileEncoding.hashCode() else 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsExtendedItemInfo (")
        printer.indent {
            print("lock = "); lock.print(printer); println()
            print("lockOwner = "); lockOwner.print(printer); println()
            print("serverItem = "); serverItem.print(printer); println()
            print("localItem = "); localItem.print(printer); println()
            print("localVersion = "); localVersion.print(printer); println()
            print("serverVersion = "); serverVersion.print(printer); println()
            print("change = "); change.print(printer); println()
            print("type = "); type.print(printer); println()
            print("lastModified = "); lastModified.print(printer); println()
            print("fileEncoding = "); fileEncoding.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:58]
 */
abstract class TfsItemInfo (
    val serverItem: String?,
    val localItem: String?,
    val localVersion: Int,
    val serverVersion: Int,
    val change: String?,
    val type: String?,
    val lastModified: String?,
    val fileEncoding: String?
) : IPrintable {
    //companion
    
    companion object : IAbstractDeclaration<TfsItemInfo> {
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): TfsItemInfo  {
            val objectStartPosition = buffer.position
            val serverItem = buffer.readNullable { buffer.readString() }
            val localItem = buffer.readNullable { buffer.readString() }
            val localVersion = buffer.readInt()
            val serverVersion = buffer.readInt()
            val change = buffer.readNullable { buffer.readString() }
            val type = buffer.readNullable { buffer.readString() }
            val lastModified = buffer.readNullable { buffer.readString() }
            val fileEncoding = buffer.readNullable { buffer.readString() }
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return TfsItemInfo_Unknown(serverItem, localItem, localVersion, serverVersion, change, type, lastModified, fileEncoding, unknownId, unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    //deepClone
    //contexts
    //threading
}


class TfsItemInfo_Unknown (
    serverItem: String?,
    localItem: String?,
    localVersion: Int,
    serverVersion: Int,
    change: String?,
    type: String?,
    lastModified: String?,
    fileEncoding: String?,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : TfsItemInfo (
    serverItem,
    localItem,
    localVersion,
    serverVersion,
    change,
    type,
    lastModified,
    fileEncoding
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<TfsItemInfo_Unknown> {
        override val _type: KClass<TfsItemInfo_Unknown> = TfsItemInfo_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsItemInfo_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsItemInfo_Unknown)  {
            buffer.writeNullable(value.serverItem) { buffer.writeString(it) }
            buffer.writeNullable(value.localItem) { buffer.writeString(it) }
            buffer.writeInt(value.localVersion)
            buffer.writeInt(value.serverVersion)
            buffer.writeNullable(value.change) { buffer.writeString(it) }
            buffer.writeNullable(value.type) { buffer.writeString(it) }
            buffer.writeNullable(value.lastModified) { buffer.writeString(it) }
            buffer.writeNullable(value.fileEncoding) { buffer.writeString(it) }
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsItemInfo_Unknown
        
        if (serverItem != other.serverItem) return false
        if (localItem != other.localItem) return false
        if (localVersion != other.localVersion) return false
        if (serverVersion != other.serverVersion) return false
        if (change != other.change) return false
        if (type != other.type) return false
        if (lastModified != other.lastModified) return false
        if (fileEncoding != other.fileEncoding) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + if (serverItem != null) serverItem.hashCode() else 0
        __r = __r*31 + if (localItem != null) localItem.hashCode() else 0
        __r = __r*31 + localVersion.hashCode()
        __r = __r*31 + serverVersion.hashCode()
        __r = __r*31 + if (change != null) change.hashCode() else 0
        __r = __r*31 + if (type != null) type.hashCode() else 0
        __r = __r*31 + if (lastModified != null) lastModified.hashCode() else 0
        __r = __r*31 + if (fileEncoding != null) fileEncoding.hashCode() else 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsItemInfo_Unknown (")
        printer.indent {
            print("serverItem = "); serverItem.print(printer); println()
            print("localItem = "); localItem.print(printer); println()
            print("localVersion = "); localVersion.print(printer); println()
            print("serverVersion = "); serverVersion.print(printer); println()
            print("change = "); change.print(printer); println()
            print("type = "); type.print(printer); println()
            print("lastModified = "); lastModified.print(printer); println()
            print("fileEncoding = "); fileEncoding.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:69]
 */
class TfsLocalItemInfo (
    serverItem: String?,
    localItem: String?,
    localVersion: Int,
    serverVersion: Int,
    change: String?,
    type: String?,
    lastModified: String?,
    fileEncoding: String?
) : TfsItemInfo (
    serverItem,
    localItem,
    localVersion,
    serverVersion,
    change,
    type,
    lastModified,
    fileEncoding
) {
    //companion
    
    companion object : IMarshaller<TfsLocalItemInfo> {
        override val _type: KClass<TfsLocalItemInfo> = TfsLocalItemInfo::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsLocalItemInfo  {
            val serverItem = buffer.readNullable { buffer.readString() }
            val localItem = buffer.readNullable { buffer.readString() }
            val localVersion = buffer.readInt()
            val serverVersion = buffer.readInt()
            val change = buffer.readNullable { buffer.readString() }
            val type = buffer.readNullable { buffer.readString() }
            val lastModified = buffer.readNullable { buffer.readString() }
            val fileEncoding = buffer.readNullable { buffer.readString() }
            return TfsLocalItemInfo(serverItem, localItem, localVersion, serverVersion, change, type, lastModified, fileEncoding)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsLocalItemInfo)  {
            buffer.writeNullable(value.serverItem) { buffer.writeString(it) }
            buffer.writeNullable(value.localItem) { buffer.writeString(it) }
            buffer.writeInt(value.localVersion)
            buffer.writeInt(value.serverVersion)
            buffer.writeNullable(value.change) { buffer.writeString(it) }
            buffer.writeNullable(value.type) { buffer.writeString(it) }
            buffer.writeNullable(value.lastModified) { buffer.writeString(it) }
            buffer.writeNullable(value.fileEncoding) { buffer.writeString(it) }
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsLocalItemInfo
        
        if (serverItem != other.serverItem) return false
        if (localItem != other.localItem) return false
        if (localVersion != other.localVersion) return false
        if (serverVersion != other.serverVersion) return false
        if (change != other.change) return false
        if (type != other.type) return false
        if (lastModified != other.lastModified) return false
        if (fileEncoding != other.fileEncoding) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + if (serverItem != null) serverItem.hashCode() else 0
        __r = __r*31 + if (localItem != null) localItem.hashCode() else 0
        __r = __r*31 + localVersion.hashCode()
        __r = __r*31 + serverVersion.hashCode()
        __r = __r*31 + if (change != null) change.hashCode() else 0
        __r = __r*31 + if (type != null) type.hashCode() else 0
        __r = __r*31 + if (lastModified != null) lastModified.hashCode() else 0
        __r = __r*31 + if (fileEncoding != null) fileEncoding.hashCode() else 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsLocalItemInfo (")
        printer.indent {
            print("serverItem = "); serverItem.print(printer); println()
            print("localItem = "); localItem.print(printer); println()
            print("localVersion = "); localVersion.print(printer); println()
            print("serverVersion = "); serverVersion.print(printer); println()
            print("change = "); change.print(printer); println()
            print("type = "); type.print(printer); println()
            print("lastModified = "); lastModified.print(printer); println()
            print("fileEncoding = "); fileEncoding.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:13]
 */
class TfsLocalPath (
    val path: String
) : TfsPath (
) {
    //companion
    
    companion object : IMarshaller<TfsLocalPath> {
        override val _type: KClass<TfsLocalPath> = TfsLocalPath::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsLocalPath  {
            val path = buffer.readString()
            return TfsLocalPath(path)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsLocalPath)  {
            buffer.writeString(value.path)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsLocalPath
        
        if (path != other.path) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + path.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsLocalPath (")
        printer.indent {
            print("path = "); path.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:11]
 */
abstract class TfsPath (
) : IPrintable {
    //companion
    
    companion object : IAbstractDeclaration<TfsPath> {
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): TfsPath  {
            val objectStartPosition = buffer.position
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return TfsPath_Unknown(unknownId, unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    //deepClone
    //contexts
    //threading
}


class TfsPath_Unknown (
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : TfsPath (
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<TfsPath_Unknown> {
        override val _type: KClass<TfsPath_Unknown> = TfsPath_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsPath_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsPath_Unknown)  {
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsPath_Unknown
        
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsPath_Unknown (")
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:34]
 */
data class TfsPendingChange (
    val serverItem: String,
    val localItem: String,
    val version: Int,
    val owner: String,
    val date: String,
    val lock: String,
    val changeTypes: List<TfsServerStatusType>,
    val workspace: String,
    val computer: String,
    val isCandidate: Boolean,
    val sourceItem: String?
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfsPendingChange> {
        override val _type: KClass<TfsPendingChange> = TfsPendingChange::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsPendingChange  {
            val serverItem = buffer.readString()
            val localItem = buffer.readString()
            val version = buffer.readInt()
            val owner = buffer.readString()
            val date = buffer.readString()
            val lock = buffer.readString()
            val changeTypes = buffer.readList { buffer.readEnum<TfsServerStatusType>() }
            val workspace = buffer.readString()
            val computer = buffer.readString()
            val isCandidate = buffer.readBool()
            val sourceItem = buffer.readNullable { buffer.readString() }
            return TfsPendingChange(serverItem, localItem, version, owner, date, lock, changeTypes, workspace, computer, isCandidate, sourceItem)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsPendingChange)  {
            buffer.writeString(value.serverItem)
            buffer.writeString(value.localItem)
            buffer.writeInt(value.version)
            buffer.writeString(value.owner)
            buffer.writeString(value.date)
            buffer.writeString(value.lock)
            buffer.writeList(value.changeTypes) { v -> buffer.writeEnum(v) }
            buffer.writeString(value.workspace)
            buffer.writeString(value.computer)
            buffer.writeBool(value.isCandidate)
            buffer.writeNullable(value.sourceItem) { buffer.writeString(it) }
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsPendingChange
        
        if (serverItem != other.serverItem) return false
        if (localItem != other.localItem) return false
        if (version != other.version) return false
        if (owner != other.owner) return false
        if (date != other.date) return false
        if (lock != other.lock) return false
        if (changeTypes != other.changeTypes) return false
        if (workspace != other.workspace) return false
        if (computer != other.computer) return false
        if (isCandidate != other.isCandidate) return false
        if (sourceItem != other.sourceItem) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + serverItem.hashCode()
        __r = __r*31 + localItem.hashCode()
        __r = __r*31 + version.hashCode()
        __r = __r*31 + owner.hashCode()
        __r = __r*31 + date.hashCode()
        __r = __r*31 + lock.hashCode()
        __r = __r*31 + changeTypes.hashCode()
        __r = __r*31 + workspace.hashCode()
        __r = __r*31 + computer.hashCode()
        __r = __r*31 + isCandidate.hashCode()
        __r = __r*31 + if (sourceItem != null) sourceItem.hashCode() else 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsPendingChange (")
        printer.indent {
            print("serverItem = "); serverItem.print(printer); println()
            print("localItem = "); localItem.print(printer); println()
            print("version = "); version.print(printer); println()
            print("owner = "); owner.print(printer); println()
            print("date = "); date.print(printer); println()
            print("lock = "); lock.print(printer); println()
            print("changeTypes = "); changeTypes.print(printer); println()
            print("workspace = "); workspace.print(printer); println()
            print("computer = "); computer.print(printer); println()
            print("isCandidate = "); isCandidate.print(printer); println()
            print("sourceItem = "); sourceItem.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:17]
 */
class TfsServerPath (
    val workspace: String,
    val path: String
) : TfsPath (
) {
    //companion
    
    companion object : IMarshaller<TfsServerPath> {
        override val _type: KClass<TfsServerPath> = TfsServerPath::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsServerPath  {
            val workspace = buffer.readString()
            val path = buffer.readString()
            return TfsServerPath(workspace, path)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsServerPath)  {
            buffer.writeString(value.workspace)
            buffer.writeString(value.path)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsServerPath
        
        if (workspace != other.workspace) return false
        if (path != other.path) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + workspace.hashCode()
        __r = __r*31 + path.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsServerPath (")
        printer.indent {
            print("workspace = "); workspace.print(printer); println()
            print("path = "); path.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:22]
 */
enum class TfsServerStatusType {
    ADD, 
    RENAME, 
    EDIT, 
    DELETE, 
    UNDELETE, 
    LOCK, 
    BRANCH, 
    MERGE, 
    UNKNOWN;
    
    companion object {
        val marshaller = FrameworkMarshallers.enum<TfsServerStatusType>()
        
    }
}


/**
 * #### Generated from [TfsModel.kt:133]
 */
abstract class TfsWorkspaceInfo (
    val serverUri: String,
    val workspaceName: String
) : IPrintable {
    //companion
    
    companion object : IAbstractDeclaration<TfsWorkspaceInfo> {
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): TfsWorkspaceInfo  {
            val objectStartPosition = buffer.position
            val serverUri = buffer.readString()
            val workspaceName = buffer.readString()
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return TfsWorkspaceInfo_Unknown(serverUri, workspaceName, unknownId, unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    //deepClone
    //contexts
    //threading
}


class TfsWorkspaceInfo_Unknown (
    serverUri: String,
    workspaceName: String,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : TfsWorkspaceInfo (
    serverUri,
    workspaceName
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<TfsWorkspaceInfo_Unknown> {
        override val _type: KClass<TfsWorkspaceInfo_Unknown> = TfsWorkspaceInfo_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsWorkspaceInfo_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsWorkspaceInfo_Unknown)  {
            buffer.writeString(value.serverUri)
            buffer.writeString(value.workspaceName)
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsWorkspaceInfo_Unknown
        
        if (serverUri != other.serverUri) return false
        if (workspaceName != other.workspaceName) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + serverUri.hashCode()
        __r = __r*31 + workspaceName.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsWorkspaceInfo_Unknown (")
        printer.indent {
            print("serverUri = "); serverUri.print(printer); println()
            print("workspaceName = "); workspaceName.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:138]
 */
data class TfsWorkspaceMapping (
    val localPath: TfsLocalPath,
    val serverPath: TfsServerPath,
    val isCloaked: Boolean
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfsWorkspaceMapping> {
        override val _type: KClass<TfsWorkspaceMapping> = TfsWorkspaceMapping::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfsWorkspaceMapping  {
            val localPath = TfsLocalPath.read(ctx, buffer)
            val serverPath = TfsServerPath.read(ctx, buffer)
            val isCloaked = buffer.readBool()
            return TfsWorkspaceMapping(localPath, serverPath, isCloaked)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfsWorkspaceMapping)  {
            TfsLocalPath.write(ctx, buffer, value.localPath)
            TfsServerPath.write(ctx, buffer, value.serverPath)
            buffer.writeBool(value.isCloaked)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfsWorkspaceMapping
        
        if (localPath != other.localPath) return false
        if (serverPath != other.serverPath) return false
        if (isCloaked != other.isCloaked) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + localPath.hashCode()
        __r = __r*31 + serverPath.hashCode()
        __r = __r*31 + isCloaked.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfsWorkspaceMapping (")
        printer.indent {
            print("localPath = "); localPath.print(printer); println()
            print("serverPath = "); serverPath.print(printer); println()
            print("isCloaked = "); isCloaked.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:82]
 */
data class TfvcCheckoutParameters (
    val filePaths: List<TfsLocalPath>,
    val recursive: Boolean
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfvcCheckoutParameters> {
        override val _type: KClass<TfvcCheckoutParameters> = TfvcCheckoutParameters::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfvcCheckoutParameters  {
            val filePaths = buffer.readList { TfsLocalPath.read(ctx, buffer) }
            val recursive = buffer.readBool()
            return TfvcCheckoutParameters(filePaths, recursive)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfvcCheckoutParameters)  {
            buffer.writeList(value.filePaths) { v -> TfsLocalPath.write(ctx, buffer, v) }
            buffer.writeBool(value.recursive)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfvcCheckoutParameters
        
        if (filePaths != other.filePaths) return false
        if (recursive != other.recursive) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + filePaths.hashCode()
        __r = __r*31 + recursive.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfvcCheckoutParameters (")
        printer.indent {
            print("filePaths = "); filePaths.print(printer); println()
            print("recursive = "); recursive.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:87]
 */
data class TfvcCheckoutResult (
    val checkedOutFiles: List<TfsLocalPath>,
    val notFoundFiles: List<TfsLocalPath>,
    val errorMessages: List<String>
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfvcCheckoutResult> {
        override val _type: KClass<TfvcCheckoutResult> = TfvcCheckoutResult::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfvcCheckoutResult  {
            val checkedOutFiles = buffer.readList { TfsLocalPath.read(ctx, buffer) }
            val notFoundFiles = buffer.readList { TfsLocalPath.read(ctx, buffer) }
            val errorMessages = buffer.readList { buffer.readString() }
            return TfvcCheckoutResult(checkedOutFiles, notFoundFiles, errorMessages)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfvcCheckoutResult)  {
            buffer.writeList(value.checkedOutFiles) { v -> TfsLocalPath.write(ctx, buffer, v) }
            buffer.writeList(value.notFoundFiles) { v -> TfsLocalPath.write(ctx, buffer, v) }
            buffer.writeList(value.errorMessages) { v -> buffer.writeString(v) }
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfvcCheckoutResult
        
        if (checkedOutFiles != other.checkedOutFiles) return false
        if (notFoundFiles != other.notFoundFiles) return false
        if (errorMessages != other.errorMessages) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + checkedOutFiles.hashCode()
        __r = __r*31 + notFoundFiles.hashCode()
        __r = __r*31 + errorMessages.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfvcCheckoutResult (")
        printer.indent {
            print("checkedOutFiles = "); checkedOutFiles.print(printer); println()
            print("notFoundFiles = "); notFoundFiles.print(printer); println()
            print("errorMessages = "); errorMessages.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [TfsModel.kt:93]
 */
data class TfvcRenameRequest (
    val oldPath: TfsLocalPath,
    val newPath: TfsLocalPath
) : IPrintable {
    //companion
    
    companion object : IMarshaller<TfvcRenameRequest> {
        override val _type: KClass<TfvcRenameRequest> = TfvcRenameRequest::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): TfvcRenameRequest  {
            val oldPath = TfsLocalPath.read(ctx, buffer)
            val newPath = TfsLocalPath.read(ctx, buffer)
            return TfvcRenameRequest(oldPath, newPath)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: TfvcRenameRequest)  {
            TfsLocalPath.write(ctx, buffer, value.oldPath)
            TfsLocalPath.write(ctx, buffer, value.newPath)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as TfvcRenameRequest
        
        if (oldPath != other.oldPath) return false
        if (newPath != other.newPath) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + oldPath.hashCode()
        __r = __r*31 + newPath.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("TfvcRenameRequest (")
        printer.indent {
            print("oldPath = "); oldPath.print(printer); println()
            print("newPath = "); newPath.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}
