package com.pdcmb.covid19stats.domain.usecases.base;

/**
 * Base interface for an Synchronous Use Case (or Interactor)
 *
 * This interface is used for synchronous requests that doesn't require
 * multithreading. {@link #execute} method return value directly.
 *
 * @author Mateusz Ziomek
 * @param <I> Parameter (input) consumed by Use Case
 * @param <O> Value returned by Use Case (output)
 */
public interface BaseUseCase<I extends IRequest, O extends IResponse>{
    
    /**
     * Executes Use Case and returns value
     *
     * @param request Parameter to be passed to Use Case
     * @return Value retuned by Use Case
     */
    O execute(I request);

}